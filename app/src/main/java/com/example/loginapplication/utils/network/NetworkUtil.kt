package com.example.loginapplication.utils.network

interface NetworkUtil {
    fun isConnectedToInternet(): Boolean
    fun getConnectionType(): NetworkType
}