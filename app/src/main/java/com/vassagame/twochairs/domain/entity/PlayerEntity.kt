package com.vassagame.twochairs.domain.entity

data class PlayerEntity (
    var namePlayer : String = "",
    var questionsLost : Int = 0,
    var positiveAnswer : Int = 0,
    var negativeAnswer : Int = 0,
    var skipQuestion : Int = 0,
)