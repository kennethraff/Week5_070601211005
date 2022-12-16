package com.uc.moviecatalog.repository

import com.uc.moviecatalog.retrofit.EndPointApi
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val api: EndPointApi) {

    suspend fun getNowPlayingData
                (apiKey: String, language:String,page:Int) = api.getNowPlaying(apiKey,language,page)

    suspend fun geMovieDeatilsResults
                (apiKey: String, movie_id:Int) = api.getMovieDetails(movie_id,apiKey)

    suspend fun getMahasiswaResults()= api.getMahsiswa()




}