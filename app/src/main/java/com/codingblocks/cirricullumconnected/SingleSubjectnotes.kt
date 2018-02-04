package com.codingblocks.cirricullumconnected

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SingleSubjectnotes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlesubjectpdf)

        val webview = findViewById<WebView>(R.id.wb_pdfFile)
        webview.settings.javaScriptEnabled = true
        val pdf = intent.getStringExtra("pdf")
        webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf)

    }
}
