package com.demo.pokemon.presentation

import android.app.Application
import android.content.Context
import com.demo.pokemon.di.component.AppComponent
import com.demo.pokemon.di.component.DaggerAppComponent
import com.demo.pokemon.di.module.AppModule
import com.demo.pokemon.di.module.NetworkModule

class PokemonApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()
    }
    companion object {
        operator fun get(context: Context): PokemonApplication {
            return context.applicationContext as PokemonApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
    }




}