package com.vassagame.twochairs.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OptionGameEntity(
    var listNames : ArrayList<String> = ArrayList(),
    var numberQuestions : Int = 10
) : Parcelable
