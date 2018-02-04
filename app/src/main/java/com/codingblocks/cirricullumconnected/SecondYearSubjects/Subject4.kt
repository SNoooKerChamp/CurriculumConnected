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
import com.codingblocks.cirricullumconnected.TeacherInformation.teacherprofile
import kotlinx.android.synthetic.main.activity_subject4.*

class Subject4 : AppCompatActivity() {

    var teacherlist2 = arrayOf("Dr Op Sharma", "Dr A.k Agarwal", "Dr Sushila Rani")
    var averagelist = arrayOf("0.0", "0.0", "0.0")
    var fragmentmanager: FragmentManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject4)
        fragmentmanager = supportFragmentManager
        val a = aadapter()
        lv_subject4.adapter = a
        val average = intent.getStringExtra("Average")
        if (average != null) {
            Log.e("Verify", average)
        }
        val teachername = intent.getStringExtra("Teacher")
        if (average != null) {
            Log.e("Teacher", average);
        }

        when (teachername) {
            teacherlist2.get(0) -> {
                averagelist.set(0, average)
                a.notifyDataSetChanged()
            }
            teacherlist2.get(1) -> {
                averagelist.set(1, average)
                a.notifyDataSetChanged()
            }
            teacherlist2.get(2) -> {
                averagelist.set(2, average)
                a.notifyDataSetChanged()
            }
        }

    }

    inner class aadapter : BaseAdapter() {

        var ibpdf: ImageButton? = null
        var teachername: TextView? = null
        var tvratetheapp: TextView? = null
        var averagerating: TextView? = null

        override fun getCount(): Int {
            return teacherlist2.size
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


            teachername?.text = teacherlist2[position]
            teachername?.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)

            Glide.with(this@Subject4).load("http://kbfacilitators.com.au/wp-content/uploads/2016/03/PDF-Logo.png")
                    .into(ibpdf)


            averagerating?.text = averagelist.get(position)

            tvratetheapp?.setOnClickListener {
                val fragmenttransaction = fragmentmanager?.beginTransaction()
                fragmenttransaction?.add(R.id.Container4, Ratingfragment.newInstance(teacherlist2.get(position), "Kinematics of Machines(ME 204)"))?.commit()

            }
            ibpdf?.setOnClickListener {
                when (position) {
                    0 -> {
                        val i1 = Intent(this@Subject4, SingleSubjectnotes::class.java)
                        i1.putExtra("pdf", "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf")
                        startActivity(i1)
                    }
                    1 -> {
                        val i2 = Intent(this@Subject4, SingleSubjectnotes::class.java)
                        i2.putExtra("pdf", "http://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
                        startActivity(i2)
                    }
                    2 -> {
                        val i3 = Intent(this@Subject4, SingleSubjectnotes::class.java)
                        i3.putExtra("pdf", "http://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
                        startActivity(i3)
                    }
                }
            }

            teachername?.setOnClickListener {
                when (position) {
                    0 -> {
                        val i1 = Intent(this@Subject4, teacherprofile::class.java)
                        i1.putExtra("url", "http://www.dtu.ac.in/Web/Departments/Mechanical/faculty/opsharma.php")
                        startActivity(i1)
                    }
                    1 -> Toast.makeText(this@Subject4, "Information currently unavailable", Toast.LENGTH_LONG).show()

                    2 -> {
                        val i2 = Intent(this@Subject4, teacherprofile::class.java)
                        i2.putExtra("url", "http://www.dtu.ac.in/Web/Departments/Mechanical/faculty/sushilarani.php")
                        startActivity(i2)
                    }
                }
            }

            return convertview


        }
    }
}
