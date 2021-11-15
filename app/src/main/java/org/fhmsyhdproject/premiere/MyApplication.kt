package org.fhmsyhdproject.premiere

import android.app.Application
import org.fhmsyhdproject.premiere.core.di.databaseModule
import org.fhmsyhdproject.premiere.core.di.networkModule
import org.fhmsyhdproject.premiere.core.di.repositoryModule
import org.fhmsyhdproject.premiere.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                    listOf(
                            databaseModule,
                            networkModule,
                            repositoryModule,
                            useCaseModule,
                            viewModelModule
                    )
            )
        }
    }
}