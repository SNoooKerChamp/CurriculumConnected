package com.codingblocks.cirricullumconnected.SecondYearSubjects

import android.content.Intent
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

import com.bumptech.glide.Glide
import com.codingblocks.cirricullumconnected.R
import com.codingblocks.cirricullumconnected.RatingFragment.Ratingfragment
import com.codingblocks.cirricullumconnected.SingleSubjectnotes
import kotlinx.android.synthetic.main.activity_subject3.*

class Subject3 : AppCompatActivity() {

    var TAG = "Subject3"


    var teacherlist1 = arrayOf("Dr Raj Kr Singh", "Mr M Zunaid")
    var averagelist = arrayOf("0.0", "0.0", "0.0")
    var fragmentmanager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject3)
        fragmentmanager = supportFragmentManager

        val a = AAdapter()
        lv_subject3.adapter = a
        val average = intent.getStringExtra("Average")
        if (average != null) {
            Log.e("Verify", average)
        }
        val teachername = intent.getStringExtra("Teacher")
        if (average != null) {
            Log.e("Teacher", average);
        }

        when (teachername) {
            teacherlist1.get(0) -> {
                averagelist.set(0, average)
                a.notifyDataSetChanged()
            }
            teacherlist1.get(1) -> {
                averagelist.set(1, average)
                a.notifyDataSetChanged()
            }

        }
    }

    inner class AAdapter : BaseAdapter() {

        var ibpdf: ImageButton? = null
        var teachername: TextView? = null
        var tvratetheapp: TextView? = null
        var averagerating: TextView? = null

        override fun getCount(): Int {
            return teacherlist1.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, convertview: View?, parent: ViewGroup): View? {
            var convertview = convertview
            if (convertview == null) {
                val li = layoutInflater
                convertview = li.inflate(R.layout.single_subjectnotes, parent, false)


            }
            ibpdf = convertview?.findViewById(R.id.ib_download)
            teachername = convertview?.findViewById(R.id.tv_teachername)
            tvratetheapp = convertview?.findViewById(R.id.tv_ratetheapp)
            averagerating = convertview?.findViewById(R.id.tv_averagerating)


            teachername?.text = teacherlist1[position]
            Log.d(TAG, "getView: ")
            teachername?.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)

            Glide.with(this@Subject3).load("http://kbfacilitators.com.au/wp-content/uploads/2016/03/PDF-Logo.png")
                    .into(ibpdf)


            averagerating?.text = averagelist.get(position)

            tvratetheapp?.setOnClickListener {
                val fragmenttransaction = fragmentmanager?.beginTransaction()
                fragmenttransaction?.add(R.id.Container3, Ratingfragment.newInstance(teacherlist1.get(position), "Fluid Mechanics(ME 204)"))?.commit()

            }
            ibpdf?.setOnClickListener {
                when (position) {
                    0 -> {
                        val i1 = Intent(this@Subject3, SingleSubjectnotes::class.java)
                        i1.putExtra("pdf", "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf")
                        startActivity(i1)
                    }
                    1 -> {
                        val i2 = Intent(this@Subject3, SingleSubjectnotes::class.java)
                        i2.putExtra("pdf", "http://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
                        startActivity(i2)
                    }
                }
            }

            teachername?.setOnClickListener {
                when (position) {
                    0 -> Toast.makeText(this@Subject3, "Information currently unavailable", Toast.LENGTH_LONG).show()
                    1 -> Toast.makeText(this@Subject3, "Information currently unavailable", Toast.LENGTH_LONG).show()
                }
            }

            return convertview
        }
    }
}
