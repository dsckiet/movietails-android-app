package com.dsckiet.movietails.ui

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dsckiet.movietails.R
import com.dsckiet.movietails.databinding.ActivityMainBinding
import com.dsckiet.movietails.ui.home.fragment.HomeFragmentDirections
import com.dsckiet.movietails.ui.home.viewModel.NowPlayingViewModel
import com.dsckiet.movietails.ui.settings.fragment.SettingsFragmentDirections
import com.dsckiet.movietails.ui.wallpapers.fragment.WallpapersFragmentDirections
import com.dsckiet.movietails.utils.NetworkState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created By Anshul on 24-06-2020
 */

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val nowPlayingVM: NowPlayingViewModel by viewModel()

    private lateinit var binding :ActivityMainBinding
    private lateinit var navController: NavController
    private var prevPosNav: Int = 0

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.NavHostFragment)

        /* Bottom Navigation */
        binding.bottomNav.setTypeface(Typeface.DEFAULT_BOLD)
        initBottomNavigationView()

//        text.setOnClickListener {
//            loadData()
//        }
        nowPlayingVM.nowPlayingLiveData.observe(this, Observer { state->
            when(state){
                is NetworkState.Loading -> Log.i("State","Loading")
                is NetworkState.Error -> Log.i("State","Error")
                is NetworkState.Success -> {
                    Log.i("State","Success")
                    val list = state.data.nowPlayingMoviesList
                    //text.text = list.toString()
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

    private fun initBottomNavigationView(){
        binding.bottomNav.setNavigationChangeListener { _, position ->
            if(prevPosNav!=position) {
                when (position) {
                    0 -> {
                        binding.bottomNav.setCurrentActiveItem(0)
                        if(prevPosNav == 1){
                            navController.navigate(WallpapersFragmentDirections.actionWallpapersFragmentToHomeFragment())
                        }else{
                            navController.navigate(SettingsFragmentDirections.actionSettingsFragmentToHomeFragment())
                        }
                        prevPosNav = position
                    }
                    1 -> {
                        binding.bottomNav.setCurrentActiveItem(1)
                        if(prevPosNav == 0){
                            navController.navigate(HomeFragmentDirections.actionHomeFragmentToWallpapersFragment())
                        }else{
                            navController.navigate(SettingsFragmentDirections.actionSettingsFragmentToWallpapersFragment())
                        }
                        prevPosNav = position
                    }
                    2 -> {
                        binding.bottomNav.setCurrentActiveItem(2)
                        if(prevPosNav == 0){
                            navController.navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
                        }else{
                            navController.navigate(WallpapersFragmentDirections.actionWallpapersFragmentToSettingsFragment())
                        }
                        prevPosNav = position
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if(prevPosNav!=0){
            binding.bottomNav.setCurrentActiveItem(0)
            prevPosNav = 0
            navController.popBackStack(R.id.homeFragment,false)
        }else{
            //TODO:: Show a snack bar for back press again
            finish()
        }
    }

}