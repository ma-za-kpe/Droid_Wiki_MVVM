package com.maku.droidwikimvvm.ui.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maku.droidwikimvvm.network.WikiService
import com.maku.droidwikimvvm.repository.WikiRepository

class HomePageViewmodelFactory  (private val apiService: WikiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomePageViewmodel::class.java)) {
            return HomePageViewmodel(
                WikiRepository(apiService)
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}