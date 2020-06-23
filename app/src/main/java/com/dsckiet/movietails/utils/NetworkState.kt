package com.dsckiet.movietails.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/* store the network state of the API calls */
sealed class NetworkState<T> {
    class Loading<T> : NetworkState<T>()
    data class Success<T>(val data: T) : NetworkState<T>()
    data class Error<T>(val message: String) : NetworkState<T>()

    companion object {
        fun <T> loading() = Loading<T>()

        fun <T> success(data: T) = Success(data)

        fun <T> error(message: String) = Error<T>(message)
    }

}

/* for checking network connection available */
fun isNetworkAvailable(context: Context): Boolean? {
    var isConnected: Boolean? = false // Initial Value
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected
}