package com.yildirimomer.composetv.ui.upcoming

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yildirimomer.domain.entity.NetworkMovie
import com.yildirimomer.domain.usecase.UpcomingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
class UpcomingRepository @Inject constructor(
    private val upcomingUseCase: UpcomingUseCase
) {

    fun upcoming(): Flow<PagingData<NetworkMovie>> {
        val config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        )
        return Pager(config) {
            UpcomingDataSource(
                upcomingUseCase = upcomingUseCase
            )
        }.flow
    }
}