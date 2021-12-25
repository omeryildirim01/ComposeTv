package com.yildirimomer.data.remote

import com.yildirimomer.data.remote.response.Movie
import com.yildirimomer.data.remote.response.MoviesResponse
import com.yildirimomer.domain.entity.Movies
import com.yildirimomer.domain.entity.NetworkMovie

/**
 * Created by OMER YILDIRIM on 12/24/21.
 */
fun MoviesResponse.asMovies() = Movies(
    results = results.map { it.asMovie() },
    currentPage = 1,
    totalPages = totalPages,
)

fun Movie.asMovie() = NetworkMovie(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    voteAverage = voteAverage,
)