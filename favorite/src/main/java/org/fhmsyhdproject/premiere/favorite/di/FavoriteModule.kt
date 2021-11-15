package org.fhmsyhdproject.premiere.favorite.di

import org.fhmsyhdproject.premiere.favorite.movie.FavoriteMovieViewModel
import org.fhmsyhdproject.premiere.favorite.tvshow.FavoriteTvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { FavoriteTvShowViewModel(get()) }
}