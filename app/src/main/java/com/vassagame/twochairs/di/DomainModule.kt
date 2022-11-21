package com.vassagame.twochairs.di

import com.vassagame.twochairs.domain.usecase.game.GameUseCase
import com.vassagame.twochairs.domain.usecase.packoperation.PackInsertUseCase
import com.vassagame.twochairs.domain.usecase.packoperation.PackLoadUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GameUseCase> {
        GameUseCase(get())
    }
    factory<PackInsertUseCase> {
        PackInsertUseCase(get())
    }
    factory<PackLoadUseCase> {
        PackLoadUseCase(get())
    }
}