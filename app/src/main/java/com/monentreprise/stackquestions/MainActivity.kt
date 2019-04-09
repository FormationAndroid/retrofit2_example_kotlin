package com.monentreprise.stackquestions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import com.monentreprise.stackquestions.adapters.QuestionsAdapter
import com.monentreprise.stackquestions.api.RetrofitClient
import com.monentreprise.stackquestions.api.models.Questions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // permet de mettre un séparateur entre chaque item de notre liste
        recyclerQuestions.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))

        RetrofitClient().getClient().getQuestions().enqueue(object : retrofit2.Callback<Questions>{

            override fun onResponse(call: Call<Questions>, response: Response<Questions>) {
                if (response.isSuccessful){

                    val adapterQuestions = response.body()?.items?.let { QuestionsAdapter(it) }
                    recyclerQuestions.adapter = adapterQuestions

                }
                else
                    toast("not good response")
            }

            override fun onFailure(call: Call<Questions>, t: Throwable) {
                toast("fail")
            }

        })

    }
}
