package com.vassagame.twochairs

import android.app.Application
import com.vassagame.twochairs.di.appModule
import com.vassagame.twochairs.di.dataModule
import com.vassagame.twochairs.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}