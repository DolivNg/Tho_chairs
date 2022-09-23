package com.vassagame.twochairs.domain.usecase.game


import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.entity.PlayerEntity
import com.vassagame.twochairs.domain.reposytory.GameRepository
import java.util.*
import kotlin.collections.ArrayList

class GameUseCase(gameRepository: GameRepository) {

    private lateinit var callBack: OnEventGameCallBack
    private var random = Random()

    private lateinit var optionGame : OptionGameEntity


    var arrayId: ArrayList<Int> = ArrayList()
    var questionsArray: ArrayList<String> = ArrayList()

    var choicePlayerId = 0
    var quantityQuestions = 0

    init {
        questionsArray = gameRepository.getQuestions().clone() as ArrayList<String>
    }

    /**
     * start() - start game
     */
    fun start() {
        callBack.startGame(optionGame.playerEntity[choicePlayerId].namePlayer, createQuestion())
        quantityQuestions()
    }


    @JvmName("setCallBack1")
    fun setCallBack(callBack: OnEventGameCallBack) {
        this.callBack = callBack
    }

    fun setGameOptions(optionGame: OptionGameEntity) {
        this.optionGame = optionGame
        var id = 0;
        optionGame.playerEntity.forEach {
            it.questionsLost = optionGame.numberQuestions
        }
        optionGame.listNames.forEach { _ ->
            arrayId.add(id)
            id++
        }
        arrayId.shuffle()
        arrayId.shuffle()
        arrayId.shuffle()
    }

    /**
     * choicePlayer() - change player, if arrayId.size call for end game
     */
    private fun choicePlayer() {
        if (arrayId.size == 0)
            callBack.endGame()
        else
            choicePlayerId = arrayId[random.nextInt(arrayId.size)]
    }

    /**
     * nextQuestion(action : Int) - do positive and negative Answer, change player when question lost,
     * action - if -1 -> negative else 1 -> positive
     * */
    fun nextQuestions(action: Int) {
        if (action == -1)
            optionGame.playerEntity[choicePlayerId].negativeAnswer++
        if (action == 1)
            optionGame.playerEntity[choicePlayerId].positiveAnswer++

        optionGame.playerEntity[choicePlayerId].questionsLost--

        changePlayer()
        quantityQuestions()

        callBack.changeQuestion(createQuestion())
    }

    /**
     * quantityQuestions() - include global variable
     */
    private fun quantityQuestions() {
        quantityQuestions = optionGame.playerEntity[choicePlayerId].questionsLost
    }

    /**
     * changePlayer() - control when player no have question
     */
    private fun changePlayer() {
        if (optionGame.playerEntity[choicePlayerId].questionsLost <= 0) {
            arrayId.remove(choicePlayerId)
            choicePlayer()
            callBack.changePlayer(optionGame.playerEntity[choicePlayerId].namePlayer)
        }
    }

    /**
     * createQuestion()
     */
    private fun createQuestion(): String {
        val question =
            questionsArray[random.nextInt(questionsArray.size)]
        questionsArray.remove(question)

        val arrayName = ArrayList<String>()
        optionGame.playerEntity.forEachIndexed { id, it -> if (id != choicePlayerId) arrayName.add(it.namePlayer) }

        arrayName.add("Veduchiy")//TODO Change "veduchiy", get out Repository

        return question.replace("[player]", newValue = arrayName[random.nextInt(arrayName.size)])
    }

    /**
     * skipQuestions - call to change UI
     */
    fun skipQuestions() {
        quantityQuestions()
        optionGame.playerEntity[choicePlayerId].skipQuestion++
        callBack.changeQuestion(createQuestion())
    }

    interface OnEventGameCallBack {
        fun changePlayer(name: String)
        fun changeQuestion(question: String)
        fun startGame(name: String, question: String)
        fun endGame()
    }
}