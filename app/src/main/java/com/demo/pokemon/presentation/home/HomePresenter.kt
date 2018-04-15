package com.demo.pokemon.presentation.home

import com.demo.pokemon.domain.interactors.GetPokemonListInteractor
import com.demo.pokemon.presentation.base.BasePresenter
import javax.inject.Inject

class HomePresenter @Inject
constructor(private val interactor: GetPokemonListInteractor) : BasePresenter<HomeView>() , GetPokemonListInteractor.Callback{
    override fun success(pokemons: List<String>) {
        view?.apply {
            showProgress(false)
            showPokemon(pokemons)
        }
    }

    override fun error(error: Throwable) {
        view?.apply {
            showProgress(false)
            showError(error)
        }
    }

    fun getPokemon(limit: Int) {
        interactor.setCallback(this)
        checkViewAttached()
        view?.showProgress(true)
        interactor.getPokemon(limit)
    }
}