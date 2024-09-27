package com.nudriin.myintentapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceive: TextView = findViewById(R.id.tv_data_receive)
        val name = intent.getStringExtra(EXTRA_NAME) // mengambil data yang dikirimkan oleh intent
        val age = intent.getIntExtra(EXTRA_AGE, 0) // defaultnya 0

        tvDataReceive.text = "Name : $name, Age: $age"
    }
}