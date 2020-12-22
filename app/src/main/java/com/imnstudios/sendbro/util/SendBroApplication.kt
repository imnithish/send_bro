package com.imnstudios.sendbro.util

import android.app.Application
import android.content.Context

class SendBroApplication: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: SendBroApplication? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = SendBroApplication.applicationContext()
    }
}