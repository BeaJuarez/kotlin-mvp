package com.demo.pokemon.di.module

import android.content.Context
import android.util.Log
import com.demo.pokemon.BuildConfig
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule(private val context: Context) {

    protected fun getBaseUrl() = BuildConfig.POKEAPI_API_URL

//    @Provides
//    @Singleton
//    internal fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
//            Retrofit.Builder()
//                    .baseUrl(getBaseUrl())
//                    .client(okHttpClient)
//                    .addConverterFactory(MoshiConverterFactory.create(moshi))
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .build()

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
            Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .client(okHttpClient)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

//    @Provides
//    @Singleton
//    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
//                                     chuckInterceptor: ChuckInterceptor,
//                                     stethoInterceptor: StethoInterceptor): OkHttpClient {
//        val httpClientBuilder = OkHttpClient.Builder()
//        if (BuildConfig.DEBUG) {
//            httpClientBuilder.addInterceptor(httpLoggingInterceptor)
//            httpClientBuilder.addInterceptor(chuckInterceptor)
//            httpClientBuilder.addNetworkInterceptor(stethoInterceptor)
//        }
//        return httpClientBuilder.build()
//
//    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        return httpClientBuilder.build()

    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor { message ->
                Log.d("HTTP",message)
            }.setLevel(HttpLoggingInterceptor.Level.BODY)

//    @Provides
//    @Singleton
//    internal fun provideChuckInterceptor(): ChuckInterceptor = ChuckInterceptor(context)
//
//    @Provides
//    @Singleton
//    internal fun provideStetho(): StethoInterceptor = StethoInterceptor()
//
    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi = Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
}