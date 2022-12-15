package com.vassagame.twochairs.data.db.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "question",
    foreignKeys = [ForeignKey(
        entity = PackEntity::class,
        parentColumns = ["id"],
        childColumns = ["pack_id"],
        onDelete = CASCADE
    )]
)
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "gender") val gender: Int,
    @ColumnInfo(name = "pack_id") val packId: Int,
    @ColumnInfo(name = "selected") val selected: Boolean = true,
    @ColumnInfo(name = "blits") val blits: Boolean = false,
    @ColumnInfo(name = "standard") val standard: Boolean = false,
)