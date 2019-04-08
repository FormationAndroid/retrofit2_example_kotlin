package com.monentreprise.stackquestions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.monentreprise.stackquestions.api.RetrofitClient
import com.monentreprise.stackquestions.api.models.Questions
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitClient().getClient().getQuestions().enqueue(object : retrofit2.Callback<Questions>{

            override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
                if (response.isSuccessful)
                    toast(response.body()?.items?.get(0)?.title.toString())
                else
                    toast("not good response")
            }

            override fun onFailure(call: Call<Questions>, t: Throwable) {
                toast("fail")
            }

        })

    }
}
