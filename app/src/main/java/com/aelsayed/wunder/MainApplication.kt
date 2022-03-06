package com.aelsayed.wunder

import android.app.Application
import com.aelsayed.wunder.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    useCasesModule,
                    viewModelsModule
                )
            )
        }
    }
}