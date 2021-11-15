package org.fhmsyhdproject.premiere.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTvShowResponse (
    @field:SerializedName("page")
    val page: String,

    @field:SerializedName("results")
    val results: List<TvShowResponse>
)