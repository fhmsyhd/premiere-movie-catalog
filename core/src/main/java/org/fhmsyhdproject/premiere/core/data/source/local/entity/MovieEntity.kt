package org.fhmsyhdproject.premiere.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.fhmsyhdproject.premiere.core.utils.Constant.TABLE_MOVIE

@Entity(tableName = TABLE_MOVIE)
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "posterPath")
    var posterPath: String,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "voteAverage")
    var voteAverage: Double,

    @ColumnInfo(name = "voteCount")
    var voteCount: Int,

//    @ColumnInfo(name = "genreIds")
//    var genreIds: List<Int>,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)