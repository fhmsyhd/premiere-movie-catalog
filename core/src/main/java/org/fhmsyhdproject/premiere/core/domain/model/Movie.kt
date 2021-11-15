package org.fhmsyhdproject.premiere.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val posterPath: String,
    val popularity: Double,
    val voteAverage: Double,
    val voteCount: Int,
//    val genreIds: List<Int>,
    val isFavorite: Boolean
) : Parcelable