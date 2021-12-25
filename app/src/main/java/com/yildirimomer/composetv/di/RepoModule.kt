package com.yildirimomer.composetv.di

import com.yildirimomer.data.ComposeTvRepository
import com.yildirimomer.domain.gateway.ComposeTvGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by OMER YILDIRIM on 12/25/21.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideComposeTvGateway(
        composeTvRepository: ComposeTvRepository
    ): ComposeTvGateway = composeTvRepository
}