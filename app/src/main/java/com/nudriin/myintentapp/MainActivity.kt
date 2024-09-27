package com.nudriin.myintentapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         mengambil button dari activity
        val moveBtn: Button = findViewById(R.id.change_activity_btn)
//        this disini mengacu pada moveBtn object
        moveBtn.setOnClickListener(this) // memanggil on click event

        val moveWithDataBtn: Button = findViewById(R.id.move_act_data_btn)
        moveWithDataBtn.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.change_activity_btn -> {
//                Membuat intent pindah ke activity lain
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent) // memulai intent
            }

            R.id.move_act_data_btn -> {
                val moveIntentWithData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
//                Menambahkan data pada intent
                moveIntentWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Nurdin") // mengambil constant EXTRA_NAME dari MoveWithDataActivity
                moveIntentWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                startActivity(moveIntentWithData)
            }

        }
    }
}
