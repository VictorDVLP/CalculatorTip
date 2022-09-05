package com.example.calculadorapropina

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorapropina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = MainViewModel()
        binding.viewmodel = mainViewModel
        binding.lifecycleOwner = this
    }
}



