package com.vassagame.twochairs.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PackFull(
    @Embedded
    val body: PackEntity,
    @Relation(parentColumn = "id", entityColumn = "pack_id", entity = QuestionEntity::class)
    val question : List<QuestionEntity>
)
data class QuestionFull(
    @Embedded
    val body: QuestionEntity,
    @Relation(parentColumn = "id", entityColumn = "question_id", entity = LangEntity::class)
    val language : List<LangEntity>
)
data class LangFull(
    @Embedded
    val body: LangEntity,
    @Relation(parentColumn = "tag_id", entityColumn = "id", entity = LangTagEntity::class)
    val tag : List<LangTagEntity>
)