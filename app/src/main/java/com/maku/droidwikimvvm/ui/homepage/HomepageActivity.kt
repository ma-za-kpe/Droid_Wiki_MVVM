package com.maku.droidwikimvvm.ui.homepage

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.maku.droidwikimvvm.R
import com.maku.droidwikimvvm.network.RetrofitService
import com.maku.droidwikimvvm.network.WikiService
import com.maku.droidwikimvvm.utils.*
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.coroutines.launch
import timber.log.Timber

class HomepageActivity : ScopedActivity() {

    private var viewModel: HomePageViewmodel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d("onCreate running: ")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        handleNetworkChanges()

        initViewModels()
        initObservers()
    }

    private fun initViewModels()= launch {
        if (null == viewModel) {
            viewModel = ViewModelProvider(viewModelStore,
                HomePageViewmodelFactory(RetrofitService.createService(WikiService::class.java))
            ).get(
                HomePageViewmodel::class.java)
            viewModel!!.wikiHomepageResults()
        }
    }

    private fun initObservers() = launch {
        viewModel?.wikiHomepageResults()?.observe(this@HomepageActivity, Observer { result ->
            when (result) {
                is ResponseState.Success -> {
                    Timber.d("result: " + result)
                    home_photos_progress_bar.visibility = View.GONE
                }
                is ResponseState.InProgress -> {
                    home_photos_progress_bar.visibility = View.VISIBLE
                }
                is ResponseState.Error -> {
                    home_photos_progress_bar.visibility = View.GONE
                    Toast.makeText(this@HomepageActivity, result.exception.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    /**
     * Observe network changes i.e. Internet Connectivity
     */
    private fun handleNetworkChanges() {
        NetworkUtils.getNetworkLiveData(applicationContext).observe(this, { isConnected ->
            if (!isConnected) {

               textViewNetworkStatus.text = getString(R.string.text_no_connectivity)
                networkStatusLayout.apply {
                    alpha = 0f
                    show()
                    setBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.colorStatusNotConnected
                        ))
                    animate()
                        .alpha(1f)
                        .setDuration(ANIMATION_DURATION)
                        .setListener(null)
                }
            } else {
                textViewNetworkStatus.text = getString(R.string.text_connectivity)
                networkStatusLayout.apply {
                    setBackgroundColor( ContextCompat.getColor(
                        context,
                        R.color.colorStatusConnected
                    ))

                    animate()
                        .alpha(0f)
                        .setStartDelay(ANIMATION_DURATION)
                        .setDuration(ANIMATION_DURATION)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator) {
                                hide()
                            }
                        })
                }
            }
        })
    }


    /**
     * Companion object
     */
    companion object {
        const val ANIMATION_DURATION = 1000.toLong()
    }

}