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
import com.codingblocks.cirricullumconnected.YearTabbedActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_subject1_notes.*
import java.util.*

class Subject1 : AppCompatActivity() {
    var teacherlist = arrayOf("Mr V Jeganathan", "Mr PK Jain", "Mr Ravi Butola")
    var averagelist = arrayOf("0.0", "0.0", "0.0")

    var fragmentmanager: FragmentManager? = null


    override fun onBackPressed() {
        startActivity(Intent(this@Subject1, YearTabbedActivity::class.java))
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject1_notes)


        fragmentmanager = supportFragmentManager


        val a = Adapter()
        lv_subject1notes.adapter = a

        val average = intent.getStringExtra("Average")
        if (average != null) {
            Log.e("Verify", average)
        }
        val teachername = intent.getStringExtra("Teacher")
        if (average != null) {
            Log.e("Teacher", average);
        }

        when (teachername) {
            teacherlist.get(0) -> {
                averagelist.set(0, average)
                a.notifyDataSetChanged()
            }
            teacherlist.get(1) -> {
                averagelist.set(1, average)
                a.notifyDataSetChanged()
            }
            teacherlist.get(2) -> {
                averagelist.set(2, average)
                a.notifyDataSetChanged()
            }
        }


    }


    inner class Adapter : BaseAdapter() {


        override fun getCount(): Int {
            return teacherlist.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        var ibpdf: ImageButton? = null
        var teachername: TextView? = null

        var averagerating: TextView? = null
        var tvratetheapp: TextView? = null

        override fun getView(position: Int, convertview: View?, parent: ViewGroup): View? {
            var convertview = convertview
            if (convertview == null) {
                val li = layoutInflater
                convertview = li.inflate(R.layout.single_subjectnotes, parent, false)


            }
            ibpdf = convertview?.findViewById(R.id.ib_download)
            teachername = convertview?.findViewById(R.id.tv_teachername)

            averagerating = convertview?.findViewById(R.id.tv_averagerating)
            teachername?.text = teacherlist[position]
            tvratetheapp = convertview?.findViewById(R.id.tv_ratetheapp)
            teachername?.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG)


            Glide.with(this@Subject1).load("http://kbfacilitators.com.au/wp-content/uploads/2016/03/PDF-Logo.png")
                    .into(ibpdf)

            averagerating?.text = averagelist.get(position)

            tvratetheapp?.setOnClickListener {
                val fragmenttransaction = fragmentmanager?.beginTransaction()
                fragmenttransaction?.add(R.id.Container1, Ratingfragment.newInstance(teacherlist.get(position), "ManufacturingMachines"))?.commit()

            }









            ibpdf?.setOnClickListener {
                when (position) {
                    0 -> {
                        val i1 = Intent(this@Subject1, SingleSubjectnotes::class.java)
                        i1.putExtra("pdf", "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf")
                        startActivity(i1)
                    }
                    1 -> {
                        val i2 = Intent(this@Subject1, SingleSubjectnotes::class.java)
                        i2.putExtra("pdf", "http://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
                        startActivity(i2)
                    }
                    2 -> {
                        val i3 = Intent(this@Subject1, SingleSubjectnotes::class.java)
                        i3.putExtra("pdf", "http://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
                        startActivity(i3)
                    }
                }
            }

            teachername?.setOnClickListener {
                when (position) {
                    0 -> {
                        val i1 = Intent(this@Subject1, teacherprofile::class.java)
                        i1.putExtra("url", "http://www.dtu.ac.in/Web/Departments/Mechanical/faculty/vjeganathan.php")
                        startActivity(i1)
                    }
                    1 -> {
                        val i2 = Intent(this@Subject1, teacherprofile::class.java)
                        i2.putExtra("url", "http://www.dtu.ac.in/Web/Departments/Mechanical/faculty/pkjain.php")
                        startActivity(i2)
                    }

                    2 -> Toast.makeText(this@Subject1, "Sorry!" + "Information of Guest Faculty is currently not available.", Toast.LENGTH_LONG).show()
                }
            }

            return convertview
        }
    }
}


