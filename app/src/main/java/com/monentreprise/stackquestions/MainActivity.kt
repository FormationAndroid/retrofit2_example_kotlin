package com.monentreprise.stackquestions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.monentreprise.stackquestions.adapters.ReposAdapter
import com.monentreprise.stackquestions.api.RetrofitClient
import com.monentreprise.stackquestions.api.models.Repo
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

        RetrofitClient().getClient().getGoogleRepos().enqueue(object : retrofit2.Callback<List<Repo>>{

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                if (response.isSuccessful)
                    recyclerQuestions.adapter = response.body()?.let { ReposAdapter(it) }

            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }
}
