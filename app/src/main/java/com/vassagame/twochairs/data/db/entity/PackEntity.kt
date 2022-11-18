package com.vassagame.twochairs.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "pack")
data class PackEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "pack_name") val packName: String,
    @ColumnInfo(name = "standard") val standard: Boolean,
    @ColumnInfo(name = "selected") val selected: Boolean
)
