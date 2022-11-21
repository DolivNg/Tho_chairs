package com.vassagame.twochairs.domain.usecase.packoperation

import com.vassagame.twochairs.domain.reposytory.QuestionRepository

class PackLoadUseCase(private val gameRepository: QuestionRepository) {
    suspend fun getPackAll() = gameRepository.getPackAll()
}