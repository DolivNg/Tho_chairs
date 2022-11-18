package com.vassagame.twochairs.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vassagame.twochairs.data.db.entity.PackEntity
import com.vassagame.twochairs.data.db.entity.QuestionEntity
import com.vassagame.twochairs.data.db.dao.PackDao
import com.vassagame.twochairs.data.db.dao.QuestDao

@Database(entities = [PackEntity::class, QuestionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questDao(): QuestDao
    abstract fun packDao(): PackDao
}