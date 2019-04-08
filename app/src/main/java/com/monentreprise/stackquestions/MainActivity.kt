package com.monentreprise.stackquestions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.monentreprise.stackquestions.api.RetrofitClient
import com.monentreprise.stackquestions.api.models.Questions
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitClient().getClient().getQuestions().enqueue(object : retrofit2.Callback<Questions>{

            override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
            }

            override fun onFailure(call: Call<Questions>, t: Throwable) {
            }

        })

    }
}
