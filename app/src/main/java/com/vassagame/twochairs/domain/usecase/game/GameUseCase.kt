package com.vassagame.twochairs.domain.usecase.game


import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.entity.PlayerEntity
import com.vassagame.twochairs.domain.reposytory.GameRepository
import java.util.*
import kotlin.collections.ArrayList

class GameUseCase {

    private lateinit var  callBack: OnEventGameCallBack

    var arrayPlayer: ArrayList<PlayerEntity> = ArrayList()
    var arrayId: ArrayList<Int> = ArrayList()

    private var random = Random()

    var choicePlayerId = 0
    var questionsArray : ArrayList<String> = ArrayList()
    var questionsNum = 0

    fun start(){
        callBack.startGame(arrayPlayer[choicePlayerId].namePlayer,createQuestion())
    }

    fun setRepository(gameRepository: GameRepository){
        questionsArray = gameRepository.getQuestions().clone() as ArrayList<String>
    }
    @JvmName("setCallBack1")
    fun setCallBack(callBack: OnEventGameCallBack){
        this.callBack = callBack
    }

    fun setGameOptions(optionGame: OptionGameEntity) {
        var id = 0;
        optionGame.listNames.forEach {
            arrayPlayer.add(
                PlayerEntity(
                    it,
                    optionGame.numberQuestions,
                    0, 0, 0
                )
            )
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
        if (arrayId.size==0)
            callBack.endGame()
        else
        choicePlayerId = arrayId[random.nextInt(arrayId.size)]
    }

    /**
     * nextQuestion(action : Int) - do positive and negative Answer, change player when question lost,
     * change question
     * action - if -1 -> negative else 1 -> positive
     * */
    fun nextQuestions(action: Int){
        if (action == -1)
            arrayPlayer[choicePlayerId].negativeAnswer++
        if (action == 1)
            arrayPlayer[choicePlayerId].positiveAnswer++
        if (action != 0)

        arrayPlayer[choicePlayerId].questionsLost--

        questionsNum = arrayPlayer[choicePlayerId].questionsLost//TODO beter


        if (arrayPlayer[choicePlayerId].questionsLost<=0) {
            arrayId.remove(choicePlayerId)
            choicePlayer()
            callBack.changePlayer(arrayPlayer[choicePlayerId].namePlayer)
        }

        callBack.changeQuestion(createQuestion())
    }

    private fun createQuestion(): String{
        val question =
            questionsArray[random.nextInt(questionsArray.size)]
        questionsArray.remove(question)

        val arrayName = ArrayList<String>()
        arrayPlayer.forEachIndexed {id,it-> if (id != choicePlayerId) arrayName.add(it.namePlayer)}

        arrayName.add("Veduchiy")//TODO Change "veduchiy", get out Repository

       return question.replace("[player]", newValue =  arrayName[random.nextInt(arrayName.size)])
    }

    /**
     * skipQuestions -call to change UI
     */
    fun skipQuestions() {
        callBack.changeQuestion(createQuestion())
    }

    interface OnEventGameCallBack{
        fun changePlayer(name : String)
        fun changeQuestion(question : String, )
        fun startGame(name : String,question : String)
        fun endGame()
    }
}