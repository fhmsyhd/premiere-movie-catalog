package org.fhmsyhdproject.premiere.core.data.source.local

import kotlinx.coroutines.flow.Flow
import org.fhmsyhdproject.premiere.core.data.source.local.entity.MovieEntity
import org.fhmsyhdproject.premiere.core.data.source.local.entity.TvShowEntity
import org.fhmsyhdproject.premiere.core.data.source.local.room.MovieDao

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovie(): Flow<List<MovieEntity>> = movieDao.getAllMovie()
    
    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<MovieEntity>) = movieDao.insertMovie(movieList)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

    fun getAllTvShow(): Flow<List<TvShowEntity>> = movieDao.getAllTvShow()

    fun getFavoriteTvShow(): Flow<List<TvShowEntity>> = movieDao.getFavoriteTvShow()

    suspend fun insertTvShow(tvShowList: List<TvShowEntity>) = movieDao.insertTvShow(tvShowList)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        movieDao.updateFavoriteTvShow(tvShow)
    }
}