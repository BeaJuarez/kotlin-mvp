package com.demo.pokemon.di.module

import android.app.Activity
import com.demo.pokemon.data.PokemonRepositoryImpl
import com.demo.pokemon.domain.interactors.GetPokemonListInteractor
import com.demo.pokemon.presentation.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(activity: Activity) : ActivityModule(activity) {

    @Provides
    fun providesMainPresenter(getPokemonListInteractor: GetPokemonListInteractor): HomePresenter {
        return HomePresenter(getPokemonListInteractor)
    }


    @Provides
    fun providesGetPokemonListInteractor(pokemonRepositoryImpl: PokemonRepositoryImpl): GetPokemonListInteractor {
        return GetPokemonListInteractor(pokemonRepositoryImpl)
    }

}