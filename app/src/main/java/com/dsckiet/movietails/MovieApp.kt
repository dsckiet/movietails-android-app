package com.dsckiet.movietails

import android.app.Application
import com.dsckiet.movietails.di.networkModule
import com.dsckiet.movietails.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created By Anshul on 24-06-2020
 */

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MovieApp: Application() {
    override fun onCreate() {
        super.onCreate()
        runKoin()
    }
    private fun runKoin() {
        startKoin{
            androidContext(applicationContext)
            modules(networkModule, viewModelModule)
        }
    }
}