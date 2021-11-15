package org.fhmsyhdproject.premiere.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse (
    @field:SerializedName("created_by")
    val createdBy: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("items")
    val items: List<MovieResponse>
)