package com.uc.moviecatalog.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.moviecatalog.R
import com.uc.moviecatalog.model.Genre


class GenreAdapter(private val dataSet: ArrayList<Genre>) : //ke sini ***
    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

     class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val tvGenre: TextView
//         val tvReleased: TextView
//
//         val cvNowPlaying: CardView

         init {
             // Define click listener for the ViewHolder's View.
             tvGenre = view.findViewById(R.id.genre_textview_cardGenre)
//             tvReleased= view.findViewById(R.id.releaseTextView_nowPlaying)
//             cvNowPlaying= view.findViewById(R.id.cardView_NowPlaying)
         }
     }
     // Create new views (invoked by the layout manager)
     override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GenreAdapter.ViewHolder {
         // Create a new view, which defines the UI of the list item
         val view = LayoutInflater.from(viewGroup.context)
             .inflate(R.layout.card_genre, viewGroup, false)

         return GenreAdapter.ViewHolder(view)
     }
     // Replace the contents of a view (invoked by the layout manager)
     override fun onBindViewHolder(viewHolder: GenreAdapter.ViewHolder, position: Int) {

         // Get element from your dataset at this position and replace the
         // contents of the view with that element

         viewHolder.tvGenre.text= dataSet[position].name
//         viewHolder.tvTitleNow.text = dataSet[position].title
//         viewHolder.tvReleased.text = dataSet[position].release_date
//         viewHolder.cvNowPlaying.setOnClickListener{
//             val intent= Intent(it.context, MovieDetail::class.java)
//             intent.putExtra("movie_id",dataSet[position].id)
//             it.context.startActivity(intent)
//         }
     }

     // Return the size of your dataset (invoked by the layout manager)
     override fun getItemCount() = dataSet.size

 }