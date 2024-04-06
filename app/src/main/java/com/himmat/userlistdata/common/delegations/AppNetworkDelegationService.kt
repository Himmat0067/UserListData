package com.himmat.userlistdata.common.delegations

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log

private const val TAG = "AppNetworkDelegation"

interface CheckNetwork{
    fun isOnline(context: Context): Boolean
}

class CheckNetworkImpl: CheckNetwork{

    override fun isOnline(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager?.let {

            val capabilities = it.getNetworkCapabilities(it.activeNetwork)

            capabilities?.let {

                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                    Log.d(TAG, "isOnline: NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                }else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)){
                    Log.d(TAG, "isOnline: NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                    Log.d(TAG, "isOnline: NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                }

            }

        }

        return false
    }

}