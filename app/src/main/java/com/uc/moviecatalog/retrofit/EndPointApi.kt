package com.uc.moviecatalog.retrofit

import com.uc.moviecatalog.model.MovieDetails
import com.uc.moviecatalog.model.NowPlaying
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPointApi {
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int

    ):Response<NowPlaying> //respon yang diharapkan untuk keambil

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ):Response<MovieDetails>
}