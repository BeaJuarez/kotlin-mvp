package com.demo.pokemon.di.module

import com.demo.pokemon.data.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    @Provides
    @Singleton
    internal fun providePokemonApi(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)
}