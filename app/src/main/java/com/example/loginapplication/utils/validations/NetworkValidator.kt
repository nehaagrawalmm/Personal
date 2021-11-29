package com.example.loginapplication.utils.validations

import android.content.Context
import android.view.View
import com.example.loginapplication.utils.network.NetworkUtil

object NetworkValidator {

  fun checkNetworkConnection(view: View, context: Context, networkUtil: NetworkUtil, feedbackNeeded: Boolean = true,messageListener:ShowMessage): Boolean {
    val isConnected = networkUtil.isConnectedToInternet()
    if (!isConnected && feedbackNeeded) {
      messageListener.showMessage("Internet Not Available")
    }
    return isConnected
  }
}

interface ShowMessage{
  fun showMessage(message:String)
}