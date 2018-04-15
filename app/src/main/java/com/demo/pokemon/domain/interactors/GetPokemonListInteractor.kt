package com.demo.pokemon.domain.interactors

import com.demo.pokemon.data.PokemonRepositoryImpl
import com.demo.pokemon.utils.rx.scheduler.SchedulerUtils
import javax.inject.Inject

class GetPokemonListInteractor

@Inject
constructor(private val pokemonRepository: PokemonRepositoryImpl) {

    interface Callback {
        fun success(pokemons: List<String>)
        fun error(error: Throwable)
    }
    private lateinit var callback: GetPokemonListInteractor.Callback

    fun setCallback(callback: Callback) {
        this.callback = callback
    }
    fun getPokemon(limit: Int) {
        pokemonRepository.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({ pokemons ->
                    if(callback!=null) {
                        callback.success(pokemons)
                    }
                }) { throwable ->
                    if(callback!=null) {
                        callback.error(throwable)
                    }
                }
    }
}