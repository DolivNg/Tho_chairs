package com.vassagame.twochairs.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vassagame.twochairs.data.db.dao.PackDao
import com.vassagame.twochairs.data.db.dao.PackFullTest
import com.vassagame.twochairs.data.db.dao.QuestDao
import com.vassagame.twochairs.data.db.entity.*

@Database(entities = [PackEntity::class, QuestionEntity::class, LangTagEntity::class, LangEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questDao(): QuestDao
    abstract fun packDao(): PackDao
    abstract fun test(): PackFullTest
}