package org.fhmsyhdproject.premiere.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.fhmsyhdproject.premiere.core.R
import org.fhmsyhdproject.premiere.core.databinding.ItemMovieBinding
import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.utils.Constant.IMAGE_URL

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMovieBinding.bind(itemView)
        @SuppressLint("SetTextI18n")
        fun bind(data: Movie) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(IMAGE_URL + data.posterPath)
                        .into(imgMovie)
                tvTitle.text = data.title
                tvRating.text = "Rating : " + data.voteAverage.toString()
                tvRelease.text = data.releaseDate
                tvOverview.text = data.overview
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}