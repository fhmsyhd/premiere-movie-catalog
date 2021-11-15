package org.fhmsyhdproject.premiere.core.utils

import org.fhmsyhdproject.premiere.core.data.source.local.entity.MovieEntity
import org.fhmsyhdproject.premiere.core.data.source.local.entity.TvShowEntity
import org.fhmsyhdproject.premiere.core.data.source.remote.response.MovieResponse
import org.fhmsyhdproject.premiere.core.data.source.remote.response.TvShowResponse
import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.domain.model.TvShow

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
//                genreIds = it.genreIds,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
//                genreIds = it.genreIds,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        title = input.title,
        overview = input.overview,
        releaseDate = input.releaseDate,
        posterPath = input.posterPath,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
//        genreIds = input.genreIds,
        isFavorite = input.isFavorite
    )

    fun mapTvShowResponsesToEntities(input: List<TvShowResponse>): List<TvShowEntity> {
        val tvShowList = ArrayList<TvShowEntity>()
        input.map {
            val tvShow = TvShowEntity(
                tvShowId = it.id,
                name = it.name,
                overview = it.overview,
                firstAirDate = it.firstAirDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
//                genreIds = it.genreIds,
                isFavorite = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapTvShowEntitiesToDomain(input: List<TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                tvShowId = it.tvShowId,
                name = it.name,
                overview = it.overview,
                firstAirDate = it.firstAirDate,
                posterPath = it.posterPath,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
//                genreIds = it.genreIds,
                isFavorite = it.isFavorite
            )
        }

    fun mapTvShowDomainToEntity(input: TvShow) = TvShowEntity(
        tvShowId = input.tvShowId,
        name = input.name,
        overview = input.overview,
        firstAirDate = input.firstAirDate,
        posterPath = input.posterPath,
        popularity = input.popularity,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
//        genreIds = input.genreIds,
        isFavorite = input.isFavorite
    )
}