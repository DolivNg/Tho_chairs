package com.vassagame.twochairs.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerEntity (
    var namePlayer : String = "",
    var questionsLost : Int = 0,
    var positiveAnswer : Int = 0,
    var negativeAnswer : Int = 0,
    var skipQuestion : Int = 0
): Parcelable