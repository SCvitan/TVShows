package com.example.droid1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.droid1.databinding.TvShowLayoutAdapterBinding

import com.example.droid1.model.MoviesItem

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

        inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding):
                RecyclerView.ViewHolder(binding.root)



        private val diffCallback = object : DiffUtil.ItemCallback<MoviesItem>(){
                override fun areItemsTheSame(oldItem: MoviesItem, newItem: MoviesItem): Boolean {
                        return oldItem.id==newItem.id
                }

                override fun areContentsTheSame(oldItem: MoviesItem, newItem: MoviesItem): Boolean {
                        return newItem == oldItem
                }

        }

        private val differ = AsyncListDiffer(this, diffCallback)
        var tvShows: List<MoviesItem>
        get()= differ.currentList
        set(value){
                differ.submitList(value)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                return MyViewHolder(TvShowLayoutAdapterBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                ))
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val currentTvShow = tvShows[position]

                holder.binding.apply {
                        textView2.text = currentTvShow.name
                        imageView2.load(currentTvShow.image.original){
                                crossfade(true)
                                crossfade(1000)
                        }
                }
        }

        override fun getItemCount() = tvShows.size
        }
