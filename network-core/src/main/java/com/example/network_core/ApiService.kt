package com.example.networkcore

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("your-endpoint")
    fun checkConnection(): Call<Any>
}
