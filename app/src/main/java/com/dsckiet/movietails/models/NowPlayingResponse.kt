package com.dsckiet.movietails.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created By Anshul on 24-06-2020
 */

@Parcelize
data class NowPlayingResponse(
    @Json(name = "results")
    val nowPlayingMoviesList: List<NowPlayingMovieModel>
) : Parcelable

@Parcelize
data class NowPlayingMovieModel(

    @Json(name = "vote_average") val nowPlayingMovieRating: String = "0",
    @Json(name = "id") val nowPlayingMovieID : String = "0",
    @Json(name = "poster_path") val nowPlayingMovieImageURL: String = "",
    @Json(name = "original_title") val nowPlayingMovieTitle: String = "",
    @Json(name = "release_date") val nowPlayingMovieReleaseDate: String = ""

) : Parcelable

