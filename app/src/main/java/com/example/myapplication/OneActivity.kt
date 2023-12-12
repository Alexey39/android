package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityOneBinding


class OneActivity : AppCompatActivity(R.layout.activity_one) {
    var x1: Float = 0.0f
    var x2: Float = 0.0f
    var y1: Float = 0.0f
    var y2: Float = 0.0f
    lateinit var binding: ActivityOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
        fun onTouch(touch: MotionEvent): Boolean {
            when (touch.action) {
                MotionEvent.ACTION_DOWN -> {
                    x1 = touch.x
                    y1 = touch.y
                }
                MotionEvent.ACTION_UP -> {
                    x2 = touch.x
                    y2 = touch.y
                    if (x1 < x2) {
                        val i = Intent(this, SecondActivity::class.java)
                        startActivity(i)
                    }
                }
            }
            return false
        }
        }

    fun listener()
    {
        binding.Propusk.setOnClickListener()
        {
            startActivity(Intent(this, Extern::class.java))
        }
    }



}