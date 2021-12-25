package com.yildirimomer.data.remote

import com.yildirimomer.data.remote.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by OMER YILDIRIM on 12/24/21.
 */
interface ComposeTvService {

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") page: Int
    ): MoviesResponse

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int
    ): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: Int
    ): MoviesResponse

}
