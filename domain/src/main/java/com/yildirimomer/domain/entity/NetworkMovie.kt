package com.yildirimomer.domain.entity

import com.yildirimomer.domain.util.Constants

data class NetworkMovie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double?,
) {
    val posterUrl = Constants.POSTER_URL + posterPath
}
