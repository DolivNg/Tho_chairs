package com.vassagame.twochairs.data.db.dao

import androidx.room.Dao
import androidx.room.Query

import com.vassagame.twochairs.data.db.entity.PackFull

@Dao
interface PackFullTest {
    @Query("select * from pack")
    suspend fun getPackWithQuestion(): List<PackFull>
}