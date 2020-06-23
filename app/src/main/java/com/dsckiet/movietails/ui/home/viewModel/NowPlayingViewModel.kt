package com.dsckiet.movietails.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsckiet.movietails.models.NowPlayingResponse
import com.dsckiet.movietails.repository.MovieDataRepository
import com.dsckiet.movietails.utils.NetworkState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created By Anshul on 24-06-2020
 */

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class NowPlayingViewModel(private val repository: MovieDataRepository): ViewModel() {

    private val _nowPlayingLiveData = MutableLiveData<NetworkState<NowPlayingResponse>>()

    val nowPlayingLiveData : LiveData<NetworkState<NowPlayingResponse>> = _nowPlayingLiveData

    fun getNowPlayingData() {
        viewModelScope.launch {
            repository.getNowPlayingData().collect {
                _nowPlayingLiveData.value = it
            }
        }
    }
}