package com.vassagame.twochairs.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vassagame.twochairs.data.db.entity.PackEntity

@Dao
interface PackDao {
    @Query("SELECT * FROM pack")
    suspend fun getPackAll(): List<PackEntity>

    @Insert
    fun insertPackAll(vararg users: PackEntity)

    @Delete
    fun delete(user: PackEntity)
}