package com.imnstudios.sendbro.util

import android.util.Log
import com.imnstudios.sendbro.BuildConfig

fun String.logger(tag: String = "SendBroLogger", type: Int = 0) {
    if (BuildConfig.DEBUG)
        when (type) {
            0 -> Log.d(tag, this)
            1 -> Log.e(tag, this)
        }
}