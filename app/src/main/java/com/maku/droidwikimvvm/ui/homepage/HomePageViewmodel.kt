package com.maku.droidwikimvvm.ui.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maku.droidwikimvvm.model.homepage.Homepage
import com.maku.droidwikimvvm.repository.WikiRepository
import com.maku.droidwikimvvm.utils.ResponseState
import timber.log.Timber

class HomePageViewmodel(private val wikiRepository: WikiRepository) : ViewModel() {

    private val homepage = MutableLiveData<ResponseState<ArrayList<Homepage>>>()

    suspend fun wikiHomepageResults(): MutableLiveData<ResponseState<ArrayList<Homepage>>> {
        val response = wikiRepository.getHomepage()
        Timber.d("response: " + response)

        response.let {
            when(it){
                is ResponseState.Success -> {
                    val response = it.extractData
                    Timber.d("response: " + response)
                }
                else -> {
                    Timber.d("error in: " + it)
                    homepage.postValue(it)
                }
            }
        }
        return homepage
    }

}
