package org.fhmsyhdproject.premiere.view.home.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.fhmsyhdproject.premiere.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}