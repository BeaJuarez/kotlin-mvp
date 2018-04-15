package com.demo.pokemon.utils


import android.app.Activity
import com.demo.pokemon.presentation.PokemonApplication


val Activity.app: PokemonApplication
    get() = application as PokemonApplication

