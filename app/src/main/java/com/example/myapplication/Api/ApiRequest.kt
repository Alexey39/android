package com.example.myapplication.Api

import com.example.myapplication.Model.NewsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiRequest {
    @GET("api/News")
    fun getNews(): Call<ArrayList<NewsItem>>

    @POST("api/SendCode")
    fun postEmail(@Header("User-email") Email: String): Call<String>

    @POST("api/SignIn")
    fun code(@Header("User-email") email: String, @Header("User-code") code: String): Call<String>
}