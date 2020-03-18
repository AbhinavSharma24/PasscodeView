package com.example.passcodeview

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_options.*



class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        setContentView(R.layout.activity_options)

        first.setOnClickListener {
            val startWebViewIntent = Intent(this, WebViewActivity::class.java)
            startWebViewIntent.putExtra("website", "1")
            startActivity(startWebViewIntent)
        }

        second.setOnClickListener {
            val startWebViewIntent = Intent(this, WebViewActivity::class.java)
            startWebViewIntent.putExtra("website", "2")
            startActivity(startWebViewIntent)
        }

        third.setOnClickListener {
            val startWebViewIntent = Intent(this, WebViewActivity::class.java)
            startWebViewIntent.putExtra("website", "3")
            startActivity(startWebViewIntent)
        }

        /*vpn.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://play.google.com/store/apps/details?id=org.hola&hl=en_IN")
            startActivity(i)
        }*/
    }

    override fun onPause() {
        window.decorView.rootView.setBackgroundColor(Color.BLUE)
        super.onPause()
    }

    override fun onRestart() {
        startActivity(Intent(applicationContext,MainActivity::class.java))
        super.onRestart()
    }
}
