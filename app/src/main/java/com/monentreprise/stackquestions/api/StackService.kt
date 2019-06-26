package com.monentreprise.stackquestions.api

import com.monentreprise.stackquestions.api.models.Questions
import retrofit2.Call
import retrofit2.http.*

interface StackService {

    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions() : Call<Questions>

}