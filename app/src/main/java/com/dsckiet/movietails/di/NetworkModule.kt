package com.dsckiet.movietails.di

import com.dsckiet.movietails.network.TMDBApiService
import com.dsckiet.movietails.network.TMDBApiService.Companion.TMDB_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@FlowPreview
@ExperimentalCoroutinesApi
val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(TMDBApiService::class.java)
    }
}