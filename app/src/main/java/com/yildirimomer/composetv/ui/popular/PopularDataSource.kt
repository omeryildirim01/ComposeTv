package com.yildirimomer.composetv.ui.popular

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yildirimomer.domain.entity.NetworkMovie
import com.yildirimomer.domain.usecase.PopularUseCase
import javax.inject.Inject

/**
 * Created by OMER YILDIRIM on 12/26/21.
 */
class PopularDataSource @Inject constructor(private val popularUseCase: PopularUseCase) :
    PagingSource<Int, NetworkMovie>() {

    override fun getRefreshKey(state: PagingState<Int, NetworkMovie>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkMovie> {
        val nextPage = params.key ?: 1
        val response = popularUseCase(page = nextPage)
        return LoadResult.Page(
            data = response.results,
            prevKey =
            if (nextPage == 1) null
            else nextPage - 1,
            nextKey = nextPage.plus(1)
        )
    }
}