package com.demo.pokemon.data.api


import com.demo.pokemon.data.model.Pokemon
import com.demo.pokemon.data.model.PokemonListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int): Single<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Single<Pokemon>

}
