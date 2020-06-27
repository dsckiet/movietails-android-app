package com.dsckiet.movietails.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dsckiet.movietails.R
import com.dsckiet.movietails.repository.dataclass.DetailsListData
import kotlinx.android.synthetic.main.details_list_item.view.*

class ESTListAdapter(c: Context, private val listItem: List<DetailsListData>):
    RecyclerView.Adapter<ESTListAdapter.ViewHolder>() {
    private val context : Context = c

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.details_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listItem[position]
        holder.title.text = currentItem.title
        holder.rating.rating = currentItem.rating.toFloat()
        Glide.with(context).load(currentItem.imgUrl).placeholder(R.drawable.img_na)
            .into(holder.imgSource)
    }

    override fun getItemCount(): Int = listItem.size

    class ViewHolder(unitView: View): RecyclerView.ViewHolder(unitView){
        val imgSource: ImageView = unitView.details_list_img
        val title: TextView = unitView.details_list_title
        val rating: RatingBar = unitView.details_list_ratingBar
    }
}