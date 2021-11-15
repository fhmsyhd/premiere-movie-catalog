package org.fhmsyhdproject.premiere.view.home.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.fhmsyhdproject.premiere.core.domain.usecase.MovieUseCase

class TvShowViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val tvShow = movieUseCase.getAllTvShow().asLiveData()
}