package com.vassagame.twochairs.gameoption

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vassagame.twochairs.domain.entity.OptionGameEntity

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
        if (id.toInt() > 0) {
            val dataGame = data.value
            data.value?.numberQuestions = id.toInt()
            data.value = dataGame!!
        }
    }

    fun addName(string: String) {
        val dataGame = data.value
        dataGame?.listNames?.add(string)
        data.value = dataGame!!
    }


}