package com.vassagame.twochairs.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vassagame.twochairs.data.db.entity.QuestionEntity

@Dao
interface QuestDao {

    @Query("SELECT * FROM question")
    fun getAll(): List<QuestionEntity>

    @Insert
    fun insertAll(vararg users: QuestionEntity)

    @Delete
    fun delete(user: QuestionEntity)
}