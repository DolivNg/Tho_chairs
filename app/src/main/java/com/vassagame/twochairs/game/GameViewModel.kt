package com.vassagame.twochairs.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vassagame.twochairs.data.GameRepositoryImpl
import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.usecase.game.GameUseCase

class GameViewModel(private val gameUseCase : GameUseCase) : ViewModel() {
    private var data: MutableLiveData<OptionGameEntity> = MutableLiveData()
    private var num: MutableLiveData<Int> = MutableLiveData()

    init {
        num.value= gameUseCase.quantityQuestions
    }

    fun getNum(): LiveData<Int> {
        return num
    }

    fun getData(): LiveData<OptionGameEntity> {
        return data
    }

    fun setData(optionGameEntity: OptionGameEntity) {
        data.value = optionGameEntity
    }

    fun startGame(callBack: GameUseCase.OnEventGameCallBack) {
        data.value?.let { gameUseCase.setGameOptions(it) }
        gameUseCase.setCallBack(callBack)
        gameUseCase.start()
        num.value= gameUseCase.quantityQuestions
    }

    fun skipQuestionClick() {
        gameUseCase.skipQuestions()
        num.value= gameUseCase.quantityQuestions
    }

    fun changeQuestionClick(id: Int) {
        gameUseCase.nextQuestions(id)
        num.value= gameUseCase.quantityQuestions
    }
}