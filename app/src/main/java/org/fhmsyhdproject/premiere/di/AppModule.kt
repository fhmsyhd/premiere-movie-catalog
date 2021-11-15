package org.fhmsyhdproject.premiere.di

import org.fhmsyhdproject.premiere.core.domain.usecase.MovieInteractor
import org.fhmsyhdproject.premiere.core.domain.usecase.MovieUseCase
import org.fhmsyhdproject.premiere.view.detail.DetailViewModel
import org.fhmsyhdproject.premiere.view.home.movie.MovieViewModel
import org.fhmsyhdproject.premiere.view.home.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}