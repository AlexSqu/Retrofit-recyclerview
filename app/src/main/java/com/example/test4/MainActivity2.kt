package com.example.test4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import posts_data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun openinternet(view: View){
        val url = "http://vk.com"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)

//повтор загрузки данных при ошибке
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiServise::class.java)

        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                api.fetchAllPosts().enqueue(object : Callback<List<posts_data>> {
                    override fun onResponse(call: Call<List<posts_data>>, response: Response<List<posts_data>>) {

                    }

                    override fun onFailure(call: Call<List<posts_data>>, t: Throwable) {


                    }
                })
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        })

    }


}