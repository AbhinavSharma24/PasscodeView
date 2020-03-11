package com.example.passcodeview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        setContentView(R.layout.activity_web_view)

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.github.com/AbhinavSharma24")

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }

    override fun onPause() {
        window.decorView.rootView.setBackgroundColor(Color.BLUE)
        super.onPause()
    }

    override fun onRestart() {
        startActivity(Intent(applicationContext,MainActivity::class.java))
        super.onRestart()
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }
        else {
            finishAffinity()
        }
    }
}
