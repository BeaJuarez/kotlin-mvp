package com.demo.pokemon.di.component

import com.demo.pokemon.di.module.ActivityModule
import com.demo.pokemon.presentation.base.BaseActivity
import com.demo.pokemon.presentation.home.HomeActivity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(homeActivity: HomeActivity)

}
