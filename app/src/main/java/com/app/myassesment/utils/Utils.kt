package com.app.myassesment.utils

import android.content.Context
import android.net.ConnectivityManager

object Utils {

    fun  isConnected(context: Context):Boolean{
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected


    }
}
