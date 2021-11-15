package org.fhmsyhdproject.premiere.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.fhmsyhdproject.premiere.core.domain.usecase.MovieUseCase

class FavoriteMovieViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}