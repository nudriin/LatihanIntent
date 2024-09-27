package com.nudriin.myintentapp

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnChoose: Button
    private lateinit var selectValue: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        selectValue = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_choose) {
//            Cek apakah ada id yang dipilih dari setiap radio yang ada pada radio gruop
            if(selectValue.checkedRadioButtonId > 0) { // jika user tidak memilih pada radio ada maka dia akan return -1
                var value = 0
//                Lakukan pengecekan apakah ada rdaio yang dipilih
                when(selectValue.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value) // kita kirimkan result intent ke main activity
                /*
                * kita jadikan obyek resultIntent yang telah dibuat sebelumnya menjadi
                * parameter dari setResult(RESULT_CODE, Intent).
                *
                * Setelah itu, kita panggil method finish() untuk menutup MoveForResultActivity
                * dan kembali ke Activity sebelumnya.
                *
                * */
                setResult(RESULT_CODE, resultIntent) // kita kirimkan Intentnya
                finish() // setelah di tekan tombol btnChoose maka activity sekarang akan di stop
//                Ketika MoveForResultActivity telah tertutup sempurna,
            //                callback ActivityResultLauncher pada MainActivity akan dijalankan.
            }
        }
    }
}