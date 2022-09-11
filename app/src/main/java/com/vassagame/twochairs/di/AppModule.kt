package com.vassagame.twochairs.di

import com.vassagame.twochairs.game.GameViewModel
import com.vassagame.twochairs.gameoption.OptionGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<GameViewModel> {
        GameViewModel(get())
    }

    viewModel<OptionGameViewModel> {
        OptionGameViewModel()
    }
}