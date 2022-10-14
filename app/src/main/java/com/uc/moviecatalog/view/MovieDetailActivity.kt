package com.uc.moviecatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.uc.moviecatalog.adapter.CompanyAdapter
import com.uc.moviecatalog.adapter.CountryAdapter
import com.uc.moviecatalog.adapter.GenreAdapter
import com.uc.moviecatalog.adapter.NowPlayingAdapter
import com.uc.moviecatalog.databinding.ActivityMovieDetailBinding
import com.uc.moviecatalog.helper.Const
import com.uc.moviecatalog.model.Genre
import com.uc.moviecatalog.model.MovieDetails
import com.uc.moviecatalog.model.ProductionCompany
import com.uc.moviecatalog.model.ProductionCountry
import com.uc.moviecatalog.viewModel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var moviegenreAdapter: GenreAdapter
    private lateinit var movieCompanyAdapter: CompanyAdapter
    private lateinit var movieCountryAdapter: CountryAdapter
    private lateinit var buatKeHorizontalScrollView: LinearLayoutManager
    private lateinit var buatKeHorizontalScrollViewCompany: LinearLayoutManager
    private lateinit var buatKeHorizontalScrollViewCountry: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buatKeHorizontalScrollView = LinearLayoutManager(this)
        buatKeHorizontalScrollView.orientation= LinearLayoutManager.HORIZONTAL

        buatKeHorizontalScrollViewCompany = LinearLayoutManager(this)
        buatKeHorizontalScrollViewCompany.orientation= LinearLayoutManager.HORIZONTAL

        buatKeHorizontalScrollViewCountry = LinearLayoutManager(this)
        buatKeHorizontalScrollViewCountry.orientation= LinearLayoutManager.HORIZONTAL

        val movieId = intent.getIntExtra("movie_id",0)
        Toast.makeText(applicationContext,"Movie ID:${movieId}",Toast.LENGTH_SHORT).show()
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]

        viewModel.getMovieDetails(Const.API_KEY,movieId)


        viewModel.movieDetails.observe(this, Observer { response->
            binding.tvTitleMovieDetail.apply {
                text= response.title
        }
            binding.textviewOverviewMovieDetail.apply {
                text= response.overview
            }
            Glide.with(applicationContext)
                .load(Const.IMG_URL+ response.backdrop_path)
                .into(binding.imagePosterMovieDetail)
        })
        viewModel.movieGenre.observe(this, Observer { response->
            binding.recyclerViewGenreMovieDetail.layoutManager= buatKeHorizontalScrollView
            moviegenreAdapter= GenreAdapter(response as ArrayList<Genre>)
            binding.recyclerViewGenreMovieDetail.adapter= moviegenreAdapter
        })

        viewModel.movieCompany.observe(this, Observer { response->
            binding.recyclerViewCompanyMovieDetail.layoutManager= buatKeHorizontalScrollViewCompany
            movieCompanyAdapter= CompanyAdapter(response as ArrayList<ProductionCompany>)
            binding.recyclerViewCompanyMovieDetail.adapter= movieCompanyAdapter
        })

        viewModel.movieCountry.observe(this, Observer { response->
            binding.recyclerViewCountryMovieDetail.layoutManager= buatKeHorizontalScrollViewCountry
            movieCountryAdapter= CountryAdapter(response as ArrayList<ProductionCountry>)
            binding.recyclerViewCountryMovieDetail.adapter= movieCountryAdapter
        })

    }
}