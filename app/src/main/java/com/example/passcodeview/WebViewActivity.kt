package com.example.passcodeview

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class WebViewActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)

        setContentView(R.layout.activity_web_view)

        val value = intent.getStringExtra("website")

        webView.webViewClient = WebViewClient()

        if(value == "1"){
            webView.loadUrl("https://www.google.com/")
            Toast.makeText(this, "You entered google.com", Toast.LENGTH_SHORT).show()
        }
        else if(value == "2"){
            webView.loadUrl("https://www.youtube.com/")
            Toast.makeText(this, "You entered youtube.com", Toast.LENGTH_SHORT).show()
        }
        else if(value == "3"){
            webView.loadUrl("https://instagram.com/")
            Toast.makeText(this, "You entered instagram.com, But you need VPN for this.", Toast.LENGTH_SHORT).show()
        }

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.backToSiteSelector) {
            startActivity(Intent(this, OptionsActivity::class.java))
        }
        if (id == R.id.reload) {
            webView.reload()
        }

        return super.onOptionsItemSelected(item)
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
