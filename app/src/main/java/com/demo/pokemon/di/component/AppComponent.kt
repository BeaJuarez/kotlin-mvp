package com.demo.pokemon.di.component

import android.app.Application
import android.content.Context
import com.demo.pokemon.data.PokemonRepositoryImpl
import com.demo.pokemon.data.api.ApiService
import com.demo.pokemon.di.module.ApiModule
import com.demo.pokemon.di.module.AppModule
import com.demo.pokemon.di.module.HomeModule
import com.demo.pokemon.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
//@Component(modules = [AppModule::class])
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))

interface AppComponent {
    fun plus(homeModule: HomeModule): HomeComponent

    // App general modules
    fun context(): Context

    fun application(): Application

    fun dataManager(): PokemonRepositoryImpl

    fun pokemonApi(): ApiService

}
