package org.fhmsyhdproject.premiere.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.fhmsyhdproject.premiere.core.utils.Constant.TABLE_TV_SHOW

@Entity(tableName = TABLE_TV_SHOW)
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "firstAirDate")
    var firstAirDate: String,

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