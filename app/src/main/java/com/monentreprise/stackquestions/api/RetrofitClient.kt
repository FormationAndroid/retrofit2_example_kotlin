package com.monentreprise.stackquestions.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var retrofit: Retrofit? = null
    private val baseUrl = "https://api.stackexchange.com/2.2/"

    fun getClient(): StackService {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(StackService::class.java)
    }
}