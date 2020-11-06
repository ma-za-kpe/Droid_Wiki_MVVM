package com.maku.droidwikimvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maku.droidwikimvvm.ui.homepage.HomepageActivity
import com.maku.droidwikimvvm.utils.start

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HomepageActivity::class.start(this, true)

    }
}