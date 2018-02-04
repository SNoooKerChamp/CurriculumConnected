package com.codingblocks.cirricullumconnected.TeacherInformation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

import com.codingblocks.cirricullumconnected.R
import kotlinx.android.synthetic.main.activity_teacherprofile.*

class teacherprofile : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacherprofile)

        val url = intent.getStringExtra("url")
        wb_teacherprofile.loadUrl(url)
    }
}
