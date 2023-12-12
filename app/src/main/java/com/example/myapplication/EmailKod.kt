package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityEmailKodBinding

class EmailKod : AppCompatActivity(R.layout.activity_email_kod) {
    lateinit var binding: ActivityEmailKodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailKodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
    }

    fun listener()
    {

    }
}