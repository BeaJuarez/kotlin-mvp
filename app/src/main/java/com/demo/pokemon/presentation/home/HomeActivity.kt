package com.demo.pokemon.presentation.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.demo.pokemon.R
import com.demo.pokemon.data.model.Pokemon
import com.demo.pokemon.di.module.HomeModule
import com.demo.pokemon.presentation.base.BaseActivity
import com.demo.pokemon.presentation.widget.SpinnerLoading
import com.demo.pokemon.utils.app
import kotlinx.android.synthetic.main.home_main.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView, PokemonAdapter.Callback {


    @Inject
    lateinit var homePresenter: HomePresenter

    @Inject
    lateinit var spinnerLoading: SpinnerLoading

    val component by lazy { app.component.plus(HomeModule(this)) }

    companion object {
        private val POKEMON_COUNT = 20
    }


    override fun layoutId() = R.layout.home_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        homePresenter.attachView(this)

        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        homePresenter.detachView()
    }

    fun initUI() {
        rvPokemons.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        btPokemons.setOnClickListener {
            homePresenter.getPokemon(POKEMON_COUNT)
        }

    }


    override fun showPokemon(pokemons: List<Pokemon>) {
        btPokemons.visibility = View.GONE
        rvPokemons.visibility = View.VISIBLE

        var adapter = PokemonAdapter(pokemons,this)
        rvPokemons.adapter = adapter
    }

    override fun showProgress(show: Boolean) {
        if(show) {
            spinnerLoading.show()
        }else{
            spinnerLoading.dismiss()
        }
    }

    override fun showError(error: Throwable) {
        btPokemons.visibility = View.VISIBLE
        rvPokemons.visibility = View.GONE
        Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
    }


    override fun onPokemonSelected(position: Int) {
        Toast.makeText(this, "Position clicked "+position , Toast.LENGTH_SHORT).show()
    }

}
