package org.fhmsyhdproject.premiere.core.domain.usecase

import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.domain.model.TvShow
import org.fhmsyhdproject.premiere.core.domain.repository.IMovieRepository

class MovieInteractor(private val  movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = movieRepository.setFavoriteMovie(movie, state)

    override fun getAllTvShow() = movieRepository.getAllTvShow()

    override fun getFavoriteTvShow() = movieRepository.getFavoriteTvShow()

    override fun setFavoriteTvShow(tvShow: TvShow, state: Boolean) = movieRepository.setFavoriteTvShow(tvShow, state)

}