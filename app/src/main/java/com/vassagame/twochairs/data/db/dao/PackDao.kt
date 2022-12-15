package com.vassagame.twochairs.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vassagame.twochairs.data.db.entity.PackEntity
import com.vassagame.twochairs.data.db.entity.PackFull

@Dao
interface PackDao {
    @Query("select * from pack")
    suspend fun getPackAll(): List<PackEntity>

    @Insert
    fun insertPackAll(vararg users: PackEntity)

    @Delete
    fun delete(user: PackEntity)
}