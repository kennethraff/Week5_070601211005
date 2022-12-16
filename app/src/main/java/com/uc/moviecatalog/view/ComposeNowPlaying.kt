package com.uc.moviecatalog.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc.moviecatalog.helper.Const
import com.uc.moviecatalog.view.ui.theme.MovieCatalogTheme
import com.uc.moviecatalog.viewModel.MoviesViewModel
import com.uc.moviecatalog.model.Result
import com.uc.moviecatalog.view.widgets.MovieCard
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ComposeNowPlaying : ComponentActivity() {
    
    private lateinit var MainviewModel: MoviesViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //Get data dari API
        MainviewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        MainviewModel.getNowPlaying(Const.API_KEY,"en-US",1)
        MainviewModel.nowPlaying.observe(this, Observer { response->
    //Menampilkan data di layar
            setContent {
                MovieCatalogTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MovieList(movieList = response)
                    }
                }
            }
        })
        
        
    }
}

@Composable
fun MovieList(movieList: ArrayList<Result>) {
   LazyColumn{
       itemsIndexed(items = movieList){index,item->
           MovieCard(movie = item)
           
       }
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieCatalogTheme {

    }
}