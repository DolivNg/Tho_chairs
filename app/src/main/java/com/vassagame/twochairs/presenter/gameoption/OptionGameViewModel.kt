package com.vassagame.twochairs.presenter.gameoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vassagame.twochairs.domain.entity.OptionGameEntity
import com.vassagame.twochairs.domain.entity.PlayerEntity

class OptionGameViewModel : ViewModel() {
    private var data: MutableLiveData<OptionGameEntity> = MutableLiveData()

    init {
        data.value = OptionGameEntity()
    }

    fun getData(): LiveData<OptionGameEntity> {
        return data
    }

    fun removeName(id: Int) {
        if (id != -1) {
            val dataGame = data.value
            dataGame?.listNames?.removeAt(id)
            data.value = dataGame!!
        }
    }

    fun setNumber(id: String) {
        if (id != "")
        if (id.toInt() > 0) {
            val dataGame = data.value
            data.value?.numberQuestions = id.toInt()
            createEntity()
            data.value = dataGame!!
        }
    }
    private fun createEntity(){
        data.value?.listNames?.forEach {
            data.value?.playerEntity?.add(
                PlayerEntity(
                    it,
                    data.value!!.numberQuestions,
                    0, 0, 0
                )
            )
        }
    }

    fun addName(string: String) {
        val dataGame = data.value
        dataGame?.listNames?.add(string)
        data.value = dataGame!!
    }
}