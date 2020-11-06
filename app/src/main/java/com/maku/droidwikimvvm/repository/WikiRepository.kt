package com.maku.droidwikimvvm.repository

import com.maku.droidwikimvvm.model.homepage.Homepage
import com.maku.droidwikimvvm.network.WikiService
import com.maku.droidwikimvvm.utils.BaseRepository.Companion.handleException
import com.maku.droidwikimvvm.utils.BaseRepository.Companion.handleSuccess
import com.maku.droidwikimvvm.utils.ResponseState
import retrofit2.HttpException
import timber.log.Timber

class WikiRepository(val apiService: WikiService) {

    companion object {
        private val TAG = WikiRepository::class.java.name
        const val GENERAL_ERROR_CODE = 499
    }

    suspend fun getHomepage(): ResponseState<ArrayList<Homepage>>? {
        Timber.d("getting home page: " )

        var result: ResponseState<ArrayList<Homepage>> = handleSuccess(arrayListOf())
        Timber.d("result: " + result)

        try {
            val response = apiService.getHomePage("parse", "Main Page", "json")
            response?.let {
                it.body()?.let { photosResponse ->
                    var result: ResponseState<Homepage> = handleSuccess(photosResponse)
                    Timber.d("response: " + result)
                }
                it.errorBody()?.let { responseErrorBody ->
                    if (responseErrorBody is HttpException) {
                        responseErrorBody.response()?.code()?.let { errorCode ->
                            result = handleException(errorCode)
                            Timber.e("error: " + responseErrorBody)
                        }
                    } else result = handleException(GENERAL_ERROR_CODE)
                }
            }
        } catch (error: Exception) {
            Timber.e("Error: ${error.message}")
            return null
        }
        return result
    }

}