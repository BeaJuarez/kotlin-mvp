package com.demo.pokemon.presentation.home

import com.demo.pokemon.data.model.Pokemon
import com.demo.pokemon.presentation.base.BaseView


interface HomeView : BaseView {

    fun showPokemon(pokemon: List<Pokemon>)

}