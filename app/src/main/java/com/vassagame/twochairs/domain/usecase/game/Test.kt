package com.vassagame.twochairs.domain.usecase.game

import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity
import com.vassagame.twochairs.domain.reposytory.QuestionRepository

class Test(private val gameRepository: QuestionRepository) {
    suspend fun getPackAll(packDomEntity: PackDomEntity){
        gameRepository.test()//.addNewPack(pack = packDomEntity)
    }
}