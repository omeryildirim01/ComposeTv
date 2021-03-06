package com.yildirimomer.domain.usecase

import com.yildirimomer.domain.entity.Movies
import com.yildirimomer.domain.gateway.ComposeTvGateway
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/24/21.
 */
class NowPlayingUseCase  @Inject constructor(
    private val composeTvGateway: ComposeTvGateway,
) {

    suspend operator fun invoke(page: Int): Movies {
        return composeTvGateway.getNowPlayingMovies(page)
    }
}