package com.vassagame.twochairs.data.db.mapper


import com.vassagame.twochairs.data.db.entity.QuestionEntity
import com.vassagame.twochairs.domain.entity.dbentity.QuestionDomEntity

class QuestionMapper {
    companion object {
        fun questionDataToDomain(questionData: QuestionEntity): QuestionDomEntity {
            return QuestionDomEntity(
                id = questionData.id,
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
                gender = questionDomain.gender,
                packId = questionDomain.packId,
                selected = questionDomain.selected,
                blits = questionDomain.blits,
                standard = questionDomain.standard
            )
        }

        fun questionArrayDataToDomainList(packArrayData: ArrayList<QuestionEntity>): ArrayList<QuestionDomEntity> {
            val array = ArrayList<QuestionDomEntity>()
            packArrayData.forEach {
                array.add(
                    questionDataToDomain(it)
                )
            }
            return array
        }

    }

}