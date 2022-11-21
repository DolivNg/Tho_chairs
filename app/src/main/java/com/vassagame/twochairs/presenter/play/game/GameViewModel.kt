package com.vassagame.twochairs.presenter.play.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity
import com.vassagame.twochairs.domain.usecase.game.GameUseCase
import com.vassagame.twochairs.domain.usecase.packoperation.PackInsertUseCase
import com.vassagame.twochairs.domain.usecase.packoperation.PackLoadUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GameViewModel(private val gameUseCase: GameUseCase,
                    private val packLoadUseCase: PackLoadUseCase,
                    private val packInsertUseCase: PackInsertUseCase) : ViewModel() {
    private var data: MutableLiveData<OptionGameEntity> = MutableLiveData()
    private var num: MutableLiveData<Int> = MutableLiveData()

    private var localList = ArrayList<PackDomEntity>()

    init {
        num.value = gameUseCase.quantityQuestions
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
        num.value = gameUseCase.quantityQuestions
    }

    fun skipQuestionClick() {
        gameUseCase.skipQuestions()
        num.value = gameUseCase.quantityQuestions
    }

    fun changeQuestionClick(id: Int) {
        gameUseCase.nextQuestions(id)
        num.value = gameUseCase.quantityQuestions
    }

    fun lunchTest() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                localList = packLoadUseCase.getPackAll()
                if (localList.isEmpty())
                    Log.d("vasa","empty")
                else
                    Log.d("vasa","full")
            }
        }

    }
}