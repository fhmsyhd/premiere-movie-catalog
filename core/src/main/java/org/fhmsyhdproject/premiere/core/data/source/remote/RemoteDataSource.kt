package org.fhmsyhdproject.premiere.core.data.source.remote

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.fhmsyhdproject.premiere.core.data.source.remote.network.ApiResponse
import org.fhmsyhdproject.premiere.core.data.source.remote.network.ApiService
import org.fhmsyhdproject.premiere.core.data.source.remote.response.MovieResponse
import org.fhmsyhdproject.premiere.core.data.source.remote.response.TvShowResponse
import org.fhmsyhdproject.premiere.core.utils.Constant.API_KEY

class RemoteDataSource(private val apiService: ApiService) {

    private val listId = "1"
    private val tvId = "2"

    suspend fun getAllMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        // get data from remote api
        return flow {
            try {
                val response = apiService.getListMovie(listId, API_KEY)
                val dataArray = response.items
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.items))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllTvShow(): Flow<ApiResponse<List<TvShowResponse>>> {
        // get data from remote api
        return flow {
            try {
                val response = apiService.getListTvShow(tvId, API_KEY)
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}