package com.demo.pokemon.presentation.home

import com.demo.pokemon.presentation.base.BaseView


interface HomeView : BaseView {

    fun showPokemon(pokemon: List<String>)

}