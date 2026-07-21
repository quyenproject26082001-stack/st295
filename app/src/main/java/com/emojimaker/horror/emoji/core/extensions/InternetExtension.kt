package com.emojimaker.horor.emoji.core.extensions

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.emojimaker.horor.emoji.R
import com.emojimaker.horor.emoji.core.helper.InternetHelper
import com.emojimaker.horor.emoji.core.utils.DataLocal
import com.emojimaker.horor.emoji.core.utils.state.HandleState
import com.emojimaker.horor.emoji.dialog.YesNoDialog


fun Context.initNetworkMonitor() {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            Log.d("nbhieu", "onAvailable")
            DataLocal.isConnectInternet.postValue(true)
        }
        override fun onLost(network: Network) {
            Log.d("nbhieu", "onLost")
            DataLocal.isConnectInternet.postValue(false)
        }
    }
    val request = NetworkRequest.Builder().build()
    connectivityManager.registerNetworkCallback(request, networkCallback)
}


fun checkDataInternet(context: AppCompatActivity, action:
(() -> Unit)) {
    InternetHelper.checkInternet(context) { result ->
        if (result == HandleState.SUCCESS) {
            action.invoke()
        } else {
            val dialog = YesNoDialog(
                context,
                R.string.no_internet,
                R.string.please_check_your_internet,
                isError = true,
            )
            dialog.show()
            dialog.onYesClick = {
                dialog.dismiss()
            }
        }
    }
}
