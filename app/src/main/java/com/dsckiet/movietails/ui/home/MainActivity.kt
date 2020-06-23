package com.dsckiet.movietails.ui.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.dsckiet.movietails.R
import com.dsckiet.movietails.ui.home.viewModel.NowPlayingViewModel
import com.dsckiet.movietails.utils.NetworkState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val nowPlayingVM: NowPlayingViewModel by viewModel()

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text.setOnClickListener {
            loadData()
        }
        nowPlayingVM.nowPlayingLiveData.observe(this, Observer { state->
            when(state){
                is NetworkState.Loading -> Log.i("State","Loading")
                is NetworkState.Error -> Log.i("State","Error")
                is NetworkState.Success -> {
                    Log.i("State","Success")
                    val list = state.data.nowPlayingMoviesList
                    text.text = list.toString()
                }
            }
        })
        if(nowPlayingVM.nowPlayingLiveData.value !is NetworkState.Success) {
            loadData()
        }

    }

    private fun loadData() {
        nowPlayingVM.getNowPlayingData()
    }
}