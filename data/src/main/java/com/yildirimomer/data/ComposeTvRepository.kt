package com.yildirimomer.data

import com.yildirimomer.data.remote.RemoteDataSource
import com.yildirimomer.domain.entity.Movies
import com.yildirimomer.domain.gateway.ComposeTvGateway
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/24/21.
 */
class ComposeTvRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): ComposeTvGateway {

    override suspend fun getPopularMovies(page: Int): Movies {
        return remoteDataSource.getPopularMovies(page)
    }

    override suspend fun getNowPlayingMovies(page: Int): Movies {
        return remoteDataSource.getNowPlaying(page)
    }

    override suspend fun getUpcomingMovies(page: Int): Movies {
        return remoteDataSource.getUpcoming(page)
    }
}