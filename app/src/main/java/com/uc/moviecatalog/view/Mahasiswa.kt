package com.uc.moviecatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.moviecatalog.databinding.ActivityMahasiswaBinding
import com.uc.moviecatalog.databinding.ActivityMovieDetailBinding
import com.uc.moviecatalog.viewModel.MoviesViewModel

class Mahasiswa : AppCompatActivity() {
    private lateinit var binding: ActivityMahasiswaBinding
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMahasiswaData()
        viewModel.mahasiswa.observe(this, Observer {
            responses ->
            Log.e("Data Mahasiswa", responses.toString())
        })
    }
}