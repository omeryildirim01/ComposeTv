package com.yildirimomer.domain.gateway

import com.yildirimomer.domain.entity.Movies

/**
 * Created by OMER YILDIRIM on 12/24/21.
 * yildirimomer01@gmail.com
 */
interface ComposeTvGateway {
    suspend fun getPopularMovies(page: Int): Movies
    suspend fun getNowPlayingMovies(page: Int): Movies
    suspend fun getUpcomingMovies(page: Int): Movies
}