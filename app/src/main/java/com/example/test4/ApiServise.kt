package com.example.test4

import posts_data
import retrofit2.Call
import retrofit2.http.GET

interface ApiServise {

    //интерфейс для создания запроса

    @GET("users")
    fun fetchAllUsers(): Call<List<User>>

    @GET("posts")
    fun fetchAllPosts(): Call<List<posts_data>>
}