package com.vassagame.twochairs.domain.entity.dbentity



data class PackDomEntity(
    val id: Int,
    val packName: String,
    val standard: Boolean,
    val selected: Boolean,
    //val questionList: ArrayList<QuestionDomEntity>
)
