package com.monentreprise.stackquestions.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val baseUrl = "https://api.github.com/"

class RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(): GithubService {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(GithubService::class.java)
    }

}