package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity(R.layout.activity_third) {
    lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
    }

    fun listener() {
        binding.Propusk.setOnClickListener()
        {
            startActivity(Intent(this, Extern::class.java))
        }
    }
}