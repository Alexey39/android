package com.example.myapplication.Api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.NewsItem
import com.example.myapplication.R
import com.example.myapplication.databinding.NewsBinding

class AdapterNews():
    RecyclerView.Adapter<AdapterNews.NewsHolder>() {
    private val newsList = ArrayList<NewsItem>()
    class NewsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = NewsBinding.bind(item)
        fun bind(result: NewsItem) = with(binding)
        {
            nameAD.text = result.name
            description.text = result.description
            cost.text = result.price.toString() + " Р"

        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news, parent, false)
            return NewsHolder(view)
    }
    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(newsList[position])
    }
    override fun getItemCount(): Int {
        return newsList.size
    }
    fun updateData(data: NewsItem) {
        newsList.add(data)
        notifyDataSetChanged()
    }

}