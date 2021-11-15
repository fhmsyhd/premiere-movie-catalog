package org.fhmsyhdproject.premiere.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
        val tvShowId: String,
        val name: String,
        val overview: String,
        val firstAirDate: String,
        val posterPath: String,
        val popularity: Double,
        val voteAverage: Double,
        val voteCount: Int,
//    val genreIds: List<Int>,
        val isFavorite: Boolean
) : Parcelable