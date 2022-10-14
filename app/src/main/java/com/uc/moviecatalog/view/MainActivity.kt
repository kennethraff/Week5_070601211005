package com.uc.moviecatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.moviecatalog.adapter.NowPlayingAdapter
import com.uc.moviecatalog.databinding.ActivityMainBinding
import com.uc.moviecatalog.helper.Const
import com.uc.moviecatalog.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NowPlayingAdapter
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this).get(MoviesViewModel::class.java)
        viewModel.getNowPlaying(Const.API_KEY,"en-US",1)

        viewModel.nowPlaying.observe(this, { response->
            binding.recyclerViewMainActivity.layoutManager= LinearLayoutManager(this)
            adapter= NowPlayingAdapter(response)
            binding.recyclerViewMainActivity.adapter= adapter
        })

    }
}