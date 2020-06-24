package com.dsckiet.movietails.ui.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dsckiet.movietails.R
import com.dsckiet.movietails.databinding.ActivityMainBinding
import com.dsckiet.movietails.ui.home.viewModel.NowPlayingViewModel
import com.dsckiet.movietails.utils.NetworkState
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

/**
 * Created By Anshul on 24-06-2020
 */

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    private val nowPlayingVM: NowPlayingViewModel by viewModel()
    private lateinit var binding :ActivityMainBinding
    private lateinit var bubbleNavigationLinearView: BubbleNavigationLinearView
    private lateinit var navController: NavController
    private var customFragmentBackStack = Stack<Int>()

    @SuppressLint("LogNotTimber")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.NavHostFragment)
        customFragmentBackStack.push(0)
        simulateBottomNavigation()
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

    private fun simulateBottomNavigation(){
        binding.bottomNav.setNavigationChangeListener{view, position ->
            Log.i("backStackOutput", customFragmentBackStack.toString())
            when(customFragmentBackStack.lastElement()){
                0 -> {
                    when (position) {
                        1 -> {
                            navController.navigate(R.id.action_homeFragment_to_wallpapersFragment)
                            customFragmentBackStack.push(1)
                        }
                        2 -> {
                            navController.navigate(R.id.action_homeFragment_to_settingsFragment)
                            customFragmentBackStack.push(2)
                        }
                    }
                }
                1 -> {
                    when (position) {
                        0 -> {
                            navController.navigate(R.id.action_wallpapersFragment_to_homeFragment)
                            customFragmentBackStack.push(0)
                        }
                        2 -> {
                            navController.navigate(R.id.action_wallpapersFragment_to_settingsFragment)
                            customFragmentBackStack.push(2)
                        }
                    }
                }
                2 -> {
                    when (position) {
                        0 -> {
                            navController.navigate(R.id.action_settingsFragment_to_homeFragment)
                            customFragmentBackStack.push(0)
                        }
                        1 -> {
                            navController.navigate(R.id.action_settingsFragment_to_wallpapersFragment)
                            customFragmentBackStack.push(1)
                        }
                    }
                }
            }
        }
    }

    /*       APP CRASHES ON BACK PRESS NAVIGATION DUE TO BUG IN THE onBackPressed()     */
//    override fun onBackPressed() {
//        super.onBackPressed()
//        when(customFragmentBackStack.lastElement()){
//            0 -> System.exit(0)
//            1 -> {
//                customFragmentBackStack.remove(customFragmentBackStack.lastElement())
//                when(customFragmentBackStack.lastElement()){
//                    0 -> navController.navigate(R.id.action_wallpapersFragment_to_homeFragment)
//                    2 -> navController.navigate(R.id.action_wallpapersFragment_to_settingsFragment)
//                }
//            }
//            2 -> {
//                customFragmentBackStack.pop()
//                when(customFragmentBackStack.lastElement()){
//                    0 -> navController.navigate(R.id.action_settingsFragment_to_homeFragment)
//                    1 -> navController.navigate(R.id.action_settingsFragment_to_wallpapersFragment)
//                }
//            }
//        }
//    }
}