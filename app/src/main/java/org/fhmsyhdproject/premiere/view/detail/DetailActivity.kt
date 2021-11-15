package org.fhmsyhdproject.premiere.view.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import org.fhmsyhdproject.premiere.R
import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.domain.model.TvShow
import org.fhmsyhdproject.premiere.databinding.ActivityDetailBinding
import org.fhmsyhdproject.premiere.utils.Constant.IMAGE_URL
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_MOVIE = "extra_data_movie"
        const val EXTRA_DATA_TV_SHOW = "extra_data_tv_show"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA_MOVIE)
        showDetailMovie(detailMovie)

        val detailTvShow = intent.getParcelableExtra<TvShow>(EXTRA_DATA_TV_SHOW)
        showDetailTvShow(detailTvShow)


        binding.btnBack.setOnClickListener { finish() }
    }

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            Glide.with(this)
                    .load(IMAGE_URL + detailMovie.posterPath)
                    .into(binding.imgMovie)
            binding.tvTitle.text = detailMovie.title
            binding.tvRating.text = "Rating : " + detailMovie.voteAverage.toString()
            binding.tvRelease.text = detailMovie.releaseDate
            binding.tvPopularity.text = detailMovie.popularity.toString()
            binding.tvAgeRating.text = detailMovie.voteCount.toString()
            binding.tvOverview.text = detailMovie.overview

            var statusFavorite = detailMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fabFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            binding.btnShare.setOnClickListener {
                ShareCompat.IntentBuilder.from(this)
                        .setType("text/plain")
                        .setChooserTitle("Share to friend")
                        .setText(getString(R.string.share_movie, detailMovie.title))
                        .startChooser()
            }
        }
    }

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    private fun showDetailTvShow(detailTvShow: TvShow?) {
        detailTvShow?.let {
            Glide.with(this)
                    .load(IMAGE_URL + detailTvShow.posterPath)
                    .into(binding.imgMovie)
            binding.tvTitle.text = detailTvShow.name
            binding.tvRating.text = "Rating : " + detailTvShow.voteAverage.toString()
            binding.tvRelease.text = detailTvShow.firstAirDate
            binding.tvPopularity.text = detailTvShow.popularity.toString()
            binding.tvAgeRating.text = detailTvShow.voteCount.toString()
            binding.tvOverview.text = detailTvShow.overview

            var statusFavorite = detailTvShow.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fabFavorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteTvShow(detailTvShow, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            binding.btnShare.setOnClickListener {
                ShareCompat.IntentBuilder.from(this)
                        .setType("text/plain")
                        .setChooserTitle("Share to friend")
                        .setText(getString(R.string.share_movie, detailTvShow.name))
                        .startChooser()
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_loved))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_love))
        }
    }
}