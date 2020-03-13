package com.example.passcodeview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_options.*

class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        first.setOnClickListener {
            startActivity(Intent(this,WebViewActivity::class.java))
        }

        second.setOnClickListener {
            startActivity(Intent(this,WebViewActivity::class.java))
        }

        third.setOnClickListener {
            Toast.makeText(this, "FUCK OFF", Toast.LENGTH_SHORT).show()
        }
    }
}
