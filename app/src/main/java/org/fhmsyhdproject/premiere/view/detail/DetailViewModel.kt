package org.fhmsyhdproject.premiere.view.detail

import androidx.lifecycle.ViewModel
import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.domain.model.TvShow
import org.fhmsyhdproject.premiere.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase): ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
            movieUseCase.setFavoriteMovie(movie, newStatus)

    fun setFavoriteTvShow(tvShow: TvShow, newStatus: Boolean) =
            movieUseCase.setFavoriteTvShow(tvShow, newStatus)
}