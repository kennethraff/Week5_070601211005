package com.uc.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uc.moviecatalog.R
import com.uc.moviecatalog.model.Genre
import com.uc.moviecatalog.model.ProductionCountry

class CountryAdapter(private val dataSet: ArrayList<ProductionCountry>) : //ke sini ***
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCountry: TextView

        init {
            // Define click listener for the ViewHolder's View.
            tvCountry = view.findViewById(R.id.country_textview_cardGenre)
   }
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_country, viewGroup, false)

        return CountryAdapter.ViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: CountryAdapter.ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.tvCountry.text= dataSet[position].name
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