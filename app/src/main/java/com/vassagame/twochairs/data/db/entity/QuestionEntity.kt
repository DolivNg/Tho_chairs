package com.vassagame.twochairs.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class QuestionEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "quest") val question: String,
    @ColumnInfo(name = "gender") val gender: Int,
    @ColumnInfo(name = "pack_id") val packId: Int,
    @ColumnInfo(name = "selected") val selected: Boolean = true,
    @ColumnInfo(name = "blits") val blits: Boolean = false,
    @ColumnInfo(name = "standard") val standard: Boolean = false
)