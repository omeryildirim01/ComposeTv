package com.yildirimomer.composetv.ui.popular

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yildirimomer.domain.entity.NetworkMovie
import com.yildirimomer.domain.usecase.PopularUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
class PopularRepository @Inject constructor(
    private val popularUseCase: PopularUseCase
) {

    fun popular(): Flow<PagingData<NetworkMovie>> {
        val config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            prefetchDistance = 5
        )
        return Pager(config) {
            PopularDataSource(
                popularUseCase = popularUseCase
            )
        }.flow
    }
}
