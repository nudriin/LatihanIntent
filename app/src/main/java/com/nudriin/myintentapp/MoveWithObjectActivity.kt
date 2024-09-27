package com.nudriin.myintentapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

//        Deklarasi tv data Received dari layout
        val tvDataReceive: TextView = findViewById(R.id.tv_obj_receive)
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

//        Jika person tidak null maka kita ekstrak datanya
        if (person != null) {
            // ekstrak person
            val text = "Name: ${person.name},\nEmail: ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            tvDataReceive.text = text
        }
    }
}