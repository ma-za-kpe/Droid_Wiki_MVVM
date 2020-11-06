package com.maku.droidwikimvvm

import android.app.Application
import timber.log.Timber

class Wiki:Application() {

    override fun onCreate() {
        super.onCreate()
        //timber
        Timber.plant(Timber.DebugTree())
    }
}