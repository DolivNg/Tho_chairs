package com.vassagame.twochairs.di

import com.vassagame.twochairs.presenter.play.game.GameViewModel
import com.vassagame.twochairs.presenter.play.gameoption.OptionGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<GameViewModel> {
        GameViewModel(get(),get(),get())
    }

    viewModel<OptionGameViewModel> {
        OptionGameViewModel()
    }
}