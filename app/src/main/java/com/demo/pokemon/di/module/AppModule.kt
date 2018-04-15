package com.demo.pokemon.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ApiModule::class))
class AppModule(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    internal fun provideContext(): Context {
        return application
    }


}