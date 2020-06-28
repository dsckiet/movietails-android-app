package com.dsckiet.movietails.ui.home.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dsckiet.movietails.R
import com.dsckiet.movietails.databinding.FragmentHomeBinding
import com.dsckiet.movietails.models.NowPlayingMovieModel
import com.dsckiet.movietails.ui.home.viewModel.NowPlayingViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import timber.log.Timber

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    @FlowPreview
    @ExperimentalCoroutinesApi
    @InternalCoroutinesApi
    private lateinit var viewModel: NowPlayingViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(NowPlayingViewModel::class.java)
        Log.d("catch_status", viewModel.nowPlayingLiveData.value.toString())
    }
}