package org.fhmsyhdproject.premiere.core.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.fhmsyhdproject.premiere.core.data.source.local.LocalDataSource
import org.fhmsyhdproject.premiere.core.data.source.remote.RemoteDataSource
import org.fhmsyhdproject.premiere.core.data.source.remote.network.ApiResponse
import org.fhmsyhdproject.premiere.core.data.source.remote.response.MovieResponse
import org.fhmsyhdproject.premiere.core.data.source.remote.response.TvShowResponse
import org.fhmsyhdproject.premiere.core.domain.model.Movie
import org.fhmsyhdproject.premiere.core.domain.model.TvShow
import org.fhmsyhdproject.premiere.core.domain.repository.IMovieRepository
import org.fhmsyhdproject.premiere.core.utils.AppExecutors
import org.fhmsyhdproject.premiere.core.utils.DataMapper

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(){
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state)}
    }

    override fun getAllTvShow(): Flow<Resource<List<TvShow>>> =
        object : NetworkBoundResource<List<TvShow>, List<TvShowResponse>>(){
            override fun loadFromDB(): Flow<List<TvShow>> {
                return localDataSource.getAllTvShow().map {
                    DataMapper.mapTvShowEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<TvShowResponse>>> =
                    remoteDataSource.getAllTvShow()

            override suspend fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.mapTvShowResponsesToEntities(data)
                localDataSource.insertTvShow(tvShowList)
            }
        }.asFlow()


    override fun getFavoriteTvShow(): Flow<List<TvShow>> {
        return localDataSource.getFavoriteTvShow().map {
            DataMapper.mapTvShowEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShow, state: Boolean) {
        val tvShowEntity = DataMapper.mapTvShowDomainToEntity(tvShow)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShowEntity, state)}
    }

}