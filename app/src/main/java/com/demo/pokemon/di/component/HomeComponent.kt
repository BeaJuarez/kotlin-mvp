package com.demo.pokemon.di.component

import com.demo.pokemon.di.module.HomeModule
import com.demo.pokemon.presentation.home.HomeActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(activity: HomeActivity)
}