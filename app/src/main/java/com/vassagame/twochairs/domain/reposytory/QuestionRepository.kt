package com.vassagame.twochairs.domain.reposytory

import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity
import com.vassagame.twochairs.domain.entity.dbentity.QuestionDomEntity

interface QuestionRepository {


    suspend fun getPackAll() : ArrayList<PackDomEntity>

    suspend fun addNewPack(pack : PackDomEntity)

    suspend fun removePack(packName : String)


    suspend fun getQuestionAll() : ArrayList<QuestionDomEntity>

    suspend fun addNewQuestion(pack : PackDomEntity)

    suspend fun removeQuestion(id : Int)

    suspend fun test()
}