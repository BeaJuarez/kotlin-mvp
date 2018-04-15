package com.demo.pokemon.di.module

import android.app.Activity
import android.content.Context
import com.demo.pokemon.presentation.widget.SpinnerLoading
import com.demo.pokemon.presentation.widget.SpinnerLoadingImpl

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ActivityModule( val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }

    @Provides
    @Singleton
    internal fun providesContext(): Context {
        return activity
    }


    @Provides
    fun provideSpinnerLoading(): SpinnerLoading {
        return SpinnerLoadingImpl(activity)
    }

}
