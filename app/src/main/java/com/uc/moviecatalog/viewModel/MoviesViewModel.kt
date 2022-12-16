package com.uc.moviecatalog.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.uc.moviecatalog.model.*
import com.uc.moviecatalog.repository.MoviesRepository
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRepository):ViewModel() {

//Now Playing data
    val _nowPlaying: MutableLiveData<ArrayList<Result>> by lazy { MutableLiveData<ArrayList<Result>>()}

    val nowPlaying: LiveData<ArrayList<Result>>
    get()= _nowPlaying

    fun getNowPlaying(apiKey:String,language:String,page: Int)=viewModelScope.launch {
        repository.getNowPlayingData(apiKey, language, page).let { 
            response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _nowPlaying.postValue(response.body()?.results as ArrayList<Result>?)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }

//Movie details data
    val _movieDetails: MutableLiveData<MovieDetails> by lazy { MutableLiveData<MovieDetails>()}

    val movieDetails: LiveData<MovieDetails>
        get()= _movieDetails

    val _movieGenre: MutableLiveData<List<Genre>> by lazy { MutableLiveData<List<Genre>>()}

    val movieGenre: LiveData<List<Genre>>
        get()= _movieGenre

    val _movieCompany: MutableLiveData<List<ProductionCompany>> by lazy { MutableLiveData<List<ProductionCompany>>()}

    val movieCompany: LiveData<List<ProductionCompany>>
        get()= _movieCompany

    val _movieCountry: MutableLiveData<List<ProductionCountry>> by lazy { MutableLiveData<List<ProductionCountry>>()}

    val movieCountry: LiveData<List<ProductionCountry>>
        get()= _movieCountry

    fun getMovieDetails(apiKey:String,movieId:Int)=viewModelScope.launch {
        repository.geMovieDeatilsResults(apiKey,movieId).let {
                response ->
            if (response.isSuccessful){
                Log.e("Get Data","Success!")
                _movieDetails.postValue(response.body() as MovieDetails)
                _movieGenre.postValue(response.body()?.genres as List<Genre>)
                _movieCompany.postValue(response.body()?.production_companies as List<ProductionCompany>)
                _movieCountry.postValue(response.body()?.production_countries as List<ProductionCountry>)
            }else {
                Log.e("Get Data","Failed!")
            }
        }
    }
//    //Get Mahasiswa
//    val _mahasiswa: MutableLiveData<JsonObject> by lazy{
//        MutableLiveData<JsonObject>()
//    }
//    val mahasiswa: LiveData<JsonObject> get() = _mahasiswa
//
//    fun getMahasiswaData() = viewModelScope.launch{
//        repository.getMahasiswaResults().let{ response ->
//            if(response.isSuccessful){
//                _mahasiswa.value = response.body()
//                val array:JsonArray= _mahasiswa.value!!.getAsJsonArray("Data")
//                for (jsonObj in array){
//                    Log.e("Test 1", jsonObj.asJsonObject["nim"].toString())
//                }
////                Log.d("Test1", _mahasiswa.value.toString())
//            }else{
//                Log.e("Get Mahasiswa Data", "Failed!")
//            }
//        }
//    }
//Get Mahasiswa
val _mahasiswa: MutableLiveData<JsonObject> by lazy {
    MutableLiveData<JsonObject>()
}

    val mahasiswa: LiveData<JsonObject>
        get() = _mahasiswa

    fun getMahasiswaData() = viewModelScope.launch {
        repository.getMahasiswaResults().let { response ->
            if (response.isSuccessful){
                _mahasiswa.value = response.body();
                val array: JsonArray = _mahasiswa.value!!.getAsJsonArray("data")
                for(jsonObj in array){
//                    var mMineUserEntity:user = Gson().fromJson(jsonObj, user::class.java)

                    Log.e("Test1", jsonObj.asJsonObject["nim"].toString())
                }

            }else{
                Log.e("Get Mahasiswa Data","Failed")
            }
        }
    }
}