package com.example.networkcore

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkHandler {

    fun checkConnection(callback: (Boolean, String?) -> Unit) {
        val apiService = ApiClient.createService(ApiService::class.java)
        val call = apiService.checkConnection()

        call.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    callback(true, null)
                } else {
                    callback(false, "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                callback(false, t.message)
            }
        })
    }
}
