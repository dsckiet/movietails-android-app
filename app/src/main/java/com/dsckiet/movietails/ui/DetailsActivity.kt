package com.dsckiet.movietails.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dsckiet.movietails.R
import com.dsckiet.movietails.databinding.ActivityDetailsBinding
import com.dsckiet.movietails.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
    }
}