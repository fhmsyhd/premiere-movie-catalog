package org.fhmsyhdproject.premiere.core.data.source.remote.network

import org.fhmsyhdproject.premiere.core.data.source.remote.response.ListMovieResponse
import org.fhmsyhdproject.premiere.core.data.source.remote.response.ListTvShowResponse
import org.fhmsyhdproject.premiere.core.utils.Constant.END_POINT_MOVIE
import org.fhmsyhdproject.premiere.core.utils.Constant.END_POINT_TV_SHOW
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT_MOVIE)
    suspend fun getListMovie(
        @Path("list_id") listId: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US"
    ): ListMovieResponse

    @GET(END_POINT_TV_SHOW)
    suspend fun getListTvShow(
        @Path("tv_id") tvId: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: String = "1"
    ): ListTvShowResponse
}
