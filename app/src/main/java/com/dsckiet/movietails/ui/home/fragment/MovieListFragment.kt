package com.dsckiet.movietails.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dsckiet.movietails.R
import com.dsckiet.movietails.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {
    private lateinit var binding: FragmentMovieListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        return binding.root
    }
}