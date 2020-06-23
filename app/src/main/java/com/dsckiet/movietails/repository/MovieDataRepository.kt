package com.dsckiet.movietails.repository

import com.dsckiet.movietails.models.NowPlayingResponse
import com.dsckiet.movietails.network.TMDBApiService
import com.dsckiet.movietails.utils.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * Created By Anshul on 24-06-2020
 */

@FlowPreview
@ExperimentalCoroutinesApi
class MovieDataRepository(private val apiService: TMDBApiService) {

    fun getNowPlayingData(): Flow<NetworkState<NowPlayingResponse>>{
        return object : NetworkRepository<NowPlayingResponse>() {
            override suspend fun fetchFromRemote(): Response<NowPlayingResponse> = apiService.getNowPlayingMovies()
        }.asFlow().flowOn(Dispatchers.IO)
    }

}