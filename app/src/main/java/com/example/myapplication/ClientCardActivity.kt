package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityClientCardBinding

class ClientCardActivity : AppCompatActivity(R.layout.activity_client_card) {
    lateinit var binding: ActivityClientCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner,
            android.R.layout.simple_spinner_item
        ).also {
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        binding.buttonCreateCard.setOnClickListener{

        }
        listener()
    }
    fun listener() {
        binding.Propuskk.setOnClickListener()
        {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}