package com.vassagame.twochairs.domain.usecase.packoperation

import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity
import com.vassagame.twochairs.domain.reposytory.QuestionRepository

class PackInsertUseCase(private val gameRepository: QuestionRepository) {
    suspend fun getPackAll(packDomEntity: PackDomEntity){
        gameRepository.addNewPack(pack = packDomEntity)
    }
}