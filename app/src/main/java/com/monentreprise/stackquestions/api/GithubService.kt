package com.monentreprise.stackquestions.api

import com.monentreprise.stackquestions.api.models.Repo
import retrofit2.Call
import retrofit2.http.*

interface GithubService {

    @GET("users/google/repos")
    fun getGoogleRepos() : Call<List<Repo>>

}