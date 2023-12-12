package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Api.ApiRequest
import com.example.myapplication.databinding.ActivityExternBinding
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class Extern : AppCompatActivity(R.layout.activity_extern) {
    lateinit var binding: ActivityExternBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExternBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()

    }


    fun listener() {
        binding.buttonExtern.setOnClickListener()
        {
            if (binding.Email.length() > 0) {
                SendEmail()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    fun SendEmail() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val gsonBuilder = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .baseUrl("https://iis.ngknn.ru/NGKNN/МамшеваЮС/MedicMadlab/")
            .client(httpClient)
            .build()

        val requestApi = retrofit.create(ApiRequest::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
               requestApi.postEmail(binding.Email.text.toString())
                   .awaitResponse()
                Log.d("Response", "Success send Email")
            } catch (e: Exception) {
                Log.d(ContentValues.TAG, e.toString()) // Вывод информации на консоль
            }
        }

    }
}
