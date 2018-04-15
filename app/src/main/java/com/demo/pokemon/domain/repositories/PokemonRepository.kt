package com.demo.pokemon.domain.repositories
import com.demo.pokemon.data.model.Pokemon
import io.reactivex.Single



interface PokemonRepository{

    fun getPokemonList(limit: Int): Single<List<Pokemon>>

    fun getPokemon(name: String): Single<Pokemon>
}
