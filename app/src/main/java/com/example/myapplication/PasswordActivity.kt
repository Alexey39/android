package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity(R.layout.activity_password) {
    lateinit var binding: ActivityPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
    }

    fun listener() {
        binding.Propusk.setOnClickListener()
        {
                startActivity(Intent(this, ClientCardActivity::class.java))
        }
    }
}
