package com.uc.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.moviecatalog.R
import com.uc.moviecatalog.helper.Const
import com.uc.moviecatalog.model.Genre
import com.uc.moviecatalog.model.ProductionCompany

class  CompanyAdapter(private val dataSet: List<ProductionCompany>) : //ke sini ***
    RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgCompany: ImageView

        init {
            // Define click listener for the ViewHolder's View.

            imgCompany= view.findViewById(R.id.imageCompany_cardCompany)
        }
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CompanyAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_company, viewGroup, false)

        return ViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: CompanyAdapter.ViewHolder, position: Int) {


        Glide.with(viewHolder.itemView).load(Const.IMG_URL+dataSet[position].logo_path).into(viewHolder.imgCompany)
//        viewHolder.tvGenre.text= dataSet[position].name

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}