package org.fhmsyhdproject.premiere.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.fhmsyhdproject.premiere.core.domain.usecase.MovieUseCase

class FavoriteTvShowViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val favoriteTvShow = movieUseCase.getFavoriteTvShow().asLiveData()
}