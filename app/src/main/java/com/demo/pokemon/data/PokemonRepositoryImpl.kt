package com.demo.pokemon.data

import com.demo.pokemon.data.api.ApiService
import com.demo.pokemon.data.model.Pokemon
import com.demo.pokemon.domain.repositories.PokemonRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject
constructor(private val apiService: ApiService) : PokemonRepository {

    override fun getPokemonList(limit: Int): Single<List<Pokemon>> {
        return apiService.getPokemonList(limit)
                .toObservable()
                .flatMapIterable { (results) -> results }
                .toList()

    }

    override fun getPokemon(name: String): Single<Pokemon> {
        return apiService.getPokemon(name)
    }
}