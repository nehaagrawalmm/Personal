package com.example.loginapplication.utils

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.loginapplication.utils.network.NetworkType
import com.example.loginapplication.utils.network.NetworkUtil

class NetworkUtilImpl(private val cm: ConnectivityManager) : NetworkUtil {

  override fun isConnectedToInternet(): Boolean {
    return getConnectionType() != com.example.loginapplication.utils.network.NetworkType.NO_INTERNET
  }

  override fun getConnectionType(): NetworkType {
    var result = NetworkType.NO_INTERNET
    result = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      getConnectionTypeAboveN()
    } else {
      getConnectionTypeBelowM()
    }
    return result
  }

  @RequiresApi(Build.VERSION_CODES.M)
  internal fun getConnectionTypeAboveN():NetworkType{
    cm.run {
      getNetworkCapabilities(activeNetwork)?.run {
        return when {
          hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
            NetworkType.WIFI
          }
          hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
            NetworkType.MOBILE
          }
          hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> {
            NetworkType.VPN
          }
          else -> NetworkType.NO_INTERNET
        }
      }
    }

    return NetworkType.NO_INTERNET
  }

  internal fun getConnectionTypeBelowM():NetworkType{
    cm.run {
      activeNetworkInfo?.run {
         return when (type) {
          ConnectivityManager.TYPE_WIFI -> {
             NetworkType.WIFI
          }
          ConnectivityManager.TYPE_MOBILE -> {
              NetworkType.MOBILE
          }
          ConnectivityManager.TYPE_VPN -> {
              NetworkType.VPN
          }
          else ->  NetworkType.NO_INTERNET
        }
      }
    }
    return NetworkType.NO_INTERNET
  }
}
