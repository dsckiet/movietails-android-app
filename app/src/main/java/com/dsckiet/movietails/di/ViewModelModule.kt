package com.dsckiet.movietails.di

import com.dsckiet.movietails.ui.home.viewModel.NowPlayingViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created By Anshul on 24-06-2020
 */

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val viewModelModule = module {
    viewModel { NowPlayingViewModel(get()) }
}