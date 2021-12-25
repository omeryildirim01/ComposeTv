package com.yildirimomer.data.remote

import com.yildirimomer.domain.entity.Movies
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/24/21.
 */
class RemoteDataSource @Inject constructor(
    private val composeTvService: ComposeTvService
) {

    suspend fun getPopularMovies(page: Int): Movies {
        return composeTvService.getPopular(page = page).asMovies()
    }

    suspend fun getNowPlaying(page: Int): Movies {
        return composeTvService.getNowPlaying(page = page).asMovies()
    }

    suspend fun getUpcoming(page: Int): Movies {
        return composeTvService.getUpcoming(page = page).asMovies()
    }
}