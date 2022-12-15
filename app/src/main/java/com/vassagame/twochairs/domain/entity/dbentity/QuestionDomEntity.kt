package com.vassagame.twochairs.domain.entity.dbentity


data class QuestionDomEntity(
    val id: Int,
    val gender: Int,
    val packId: Int,
    val selected: Boolean = true,
    val blits: Boolean = false,
    val standard: Boolean = false
)