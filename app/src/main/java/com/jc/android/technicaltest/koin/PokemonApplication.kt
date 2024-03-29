package com.jc.android.technicaltest.koin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class PokemonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@PokemonApplication)
            modules(listOf(
                repositoryModule,
                viewModelModule,
                retrofitModule,
                apiModule
            ))
        }
    }
}