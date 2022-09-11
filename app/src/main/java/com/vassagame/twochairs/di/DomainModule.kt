package com.vassagame.twochairs.di

import com.vassagame.twochairs.domain.reposytory.GameRepository
import com.vassagame.twochairs.domain.usecase.game.GameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GameUseCase> {
        GameUseCase(get())
    }
}