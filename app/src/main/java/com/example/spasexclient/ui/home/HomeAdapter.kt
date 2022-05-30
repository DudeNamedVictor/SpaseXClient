package com.example.spasexclient.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spasexclient.data.models.Fairings
import com.example.spasexclient.databinding.HomeItemBinding

class HomeAdapter(private val news: List<Fairings>) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(fairings : List<Fairings>, position: Int) {
            binding.text.text = fairings[position].reused.toString()
            binding.text2.text = fairings[position].recovered.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeItemBinding.inflate(inflater, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(news, position)
    }

    override fun getItemCount() = news.size
}