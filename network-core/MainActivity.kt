package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.networkcore.NetworkHandler
import com.example.networkcore.NetworkUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (NetworkUtil.isNetworkAvailable(this)) {
            NetworkHandler().checkConnection { isSuccess, errorMessage ->
                if (isSuccess) {
                    // API call succeeded
                } else {
                    // Handle error
                    errorMessage?.let { showError(it) }
                }
            }
        } else {
            // Handle no internet connection
            showError("No internet connection")
        }
    }

    private fun showError(message: String) {
        // Display the error
    }
}
