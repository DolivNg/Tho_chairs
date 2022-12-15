package com.vassagame.twochairs.data.db.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "pack")
data class PackEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "pack_name") val packName: String,
    @ColumnInfo(name = "standard") val standard: Boolean,
    @ColumnInfo(name = "selected") val selected: Boolean,
)