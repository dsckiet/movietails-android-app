package com.dsckiet.movietails.repository

import androidx.annotation.MainThread
import com.dsckiet.movietails.utils.NetworkState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import retrofit2.Response

@ExperimentalCoroutinesApi
abstract class NetworkRepository<T> {

    fun asFlow() = flow<NetworkState<T>> {

        // Emit Loading _root_ide_package_.com.dsckiet.movietails.utils.NetworkState
        emit(NetworkState.loading())

        try {
            // Fetch latest data from remote
            val apiResponse = fetchFromRemote()

            // Parse body
            val remotePosts = apiResponse.body()

            // Check for response validation
            if (apiResponse.isSuccessful && remotePosts != null) {
                emit(NetworkState.success(remotePosts))
            } else {
                // Something went wrong! Emit Error _root_ide_package_.com.dsckiet.movietails.utils.NetworkState.
                emit(NetworkState.error(apiResponse.message()))
            }
        } catch (e: Exception) {
            // Exception occurred! Emit error
            emit(NetworkState.error("Network error! Can't get latest data."))
            e.printStackTrace()
        }
    }

    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<T>
}