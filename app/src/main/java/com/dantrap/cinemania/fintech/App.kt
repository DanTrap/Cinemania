package com.dantrap.cinemania.fintech

import android.app.Application
import com.dantrap.cinemania.fintech.core.common.di.DispatchersModule
import com.dantrap.cinemania.fintech.core.data.di.DataModule
import com.dantrap.cinemania.fintech.core.domain.di.DomainModule
import com.dantrap.cinemania.fintech.core.network.di.NetworkModule
import com.dantrap.cinemania.fintech.di.AppModule
import com.dantrap.cinemania.fintech.feature.home.di.HomeModule
import com.dantrap.cinemania.fintech.feature.settings.di.SettingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()

            modules(
                AppModule.module,
                DispatchersModule.module,
                DomainModule.module,
                DataModule.module,
                NetworkModule.module,
                HomeModule.module,
                SettingsModule.module
            )
        }
    }
}
