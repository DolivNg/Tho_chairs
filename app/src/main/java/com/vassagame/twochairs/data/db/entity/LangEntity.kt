package com.vassagame.twochairs.data.db.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "langQuestion",
    foreignKeys = [ForeignKey(
    entity = QuestionEntity::class,
    parentColumns = ["id"],
    childColumns = ["question_id"],
    onDelete = CASCADE
)])
data class LangEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "tag_id") val tagId: Int,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "question_id") val questionId: Int,
)
