package com.vassagame.twochairs.di

import com.vassagame.twochairs.data.GameRepositoryImpl
import com.vassagame.twochairs.domain.reposytory.GameRepository
import org.koin.dsl.module

val dataModule = module {
    single<GameRepository>{
        GameRepositoryImpl(context = get())
    }
}