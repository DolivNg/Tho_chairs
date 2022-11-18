package com.vassagame.twochairs.data.db.Mapper


import com.vassagame.twochairs.data.db.entity.QuestionEntity
import com.vassagame.twochairs.domain.entity.dbentity.QuestionDomEntity

class QuestionMapper {
    fun questionDataToDomain(questionData: QuestionEntity): QuestionDomEntity {
        return QuestionDomEntity(
            id = questionData.id,
            question = questionData.question,
            gender = questionData.gender,
            packId = questionData.packId,
            selected = questionData.selected,
            blits = questionData.blits,
            standard = questionData.standard
        )
    }

    fun questionDomainToData(questionDomain: QuestionDomEntity): QuestionEntity {
        return QuestionEntity(
            id = questionDomain.id,
            question = questionDomain.question,
            gender = questionDomain.gender,
            packId = questionDomain.packId,
            selected = questionDomain.selected,
            blits = questionDomain.blits,
            standard = questionDomain.standard
        )
    }
}