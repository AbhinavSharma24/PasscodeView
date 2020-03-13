package com.example.passcodeview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hanks.passcodeview.PasscodeView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passcodeView.setPasscodeLength(5).setLocalPasscode("00000").listener = object :
            PasscodeView.PasscodeViewListener {
            override fun onSuccess(number: String?) {
                startActivity(Intent(this@MainActivity,OptionsActivity::class.java))
            }

            override fun onFail() {
                Toast.makeText(applicationContext,"Pass-code is Wrong.",Toast.LENGTH_SHORT).show()
            }

        }
    }
}
