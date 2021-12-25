package com.yildirimomer.composetv.ui.upcoming

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yildirimomer.domain.entity.NetworkMovie
import com.yildirimomer.domain.usecase.UpcomingUseCase
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
class UpcomingDataSource @Inject constructor(private val upcomingUseCase: UpcomingUseCase) :
    PagingSource<Int, NetworkMovie>() {
    override fun getRefreshKey(state: PagingState<Int, NetworkMovie>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkMovie> {
        val nextPage = params.key ?: 1
        val movieResponse = upcomingUseCase(nextPage)
        return LoadResult.Page(
            data = movieResponse.results,
            prevKey =
            if (nextPage == 1) null
            else nextPage - 1,
            nextKey = nextPage.plus(1)
        )
    }
}