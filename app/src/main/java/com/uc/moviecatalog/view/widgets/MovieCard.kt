package com.uc.moviecatalog.view.widgets

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.uc.moviecatalog.model.MovieDetails
import com.uc.moviecatalog.model.Result
import com.uc.moviecatalog.view.MovieDetailActivity

@Composable
fun MovieCard (movie: Result) {
    val mContext = LocalContext.current

    Surface(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp), shadowElevation = 8.dp,
        onClick = {
            val intent= Intent(mContext,MovieDetailActivity::class.java)
            intent.putExtra("movie_id", movie.id)
            mContext.startActivity(intent)
        }

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = movie.title,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = movie.vote_average.toString(),
                modifier = Modifier
                    .background(Color.Cyan)
                    .padding(4.dp)
            )
            Text(
                text =movie.overview,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,

            )
        }
    }
}