package org.fhmsyhdproject.premiere.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.fhmsyhdproject.premiere.core.data.Resource
import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.domain.model.TvShow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

    fun getAllTvShow(): Flow<Resource<List<TvShow>>>

    fun getFavoriteTvShow(): Flow<List<TvShow>>

    fun setFavoriteTvShow(tvShow: TvShow, state: Boolean)
}