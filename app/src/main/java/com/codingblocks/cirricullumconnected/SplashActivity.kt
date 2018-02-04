package com.codingblocks.cirricullumconnected

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.bumptech.glide.Glide
import com.shashank.sony.fancywalkthroughlib.FancyWalkthroughActivity
import com.shashank.sony.fancywalkthroughlib.FancyWalkthroughCard


import java.util.ArrayList

import de.hdodenhof.circleimageview.CircleImageView

class SplashActivity : FancyWalkthroughActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_splash);
        val card1 = FancyWalkthroughCard("Choose the year ", "Choose your current academic year and get access to variety of notes of different subjects."
        )
        val card2 = FancyWalkthroughCard("Choose the subject", "Choose the subject of interest for notes and other study material")
        val card3 = FancyWalkthroughCard("Choose the teacher", "Shuffle around the notes of all the subject teachers and rate and review them accordingly")

        card1.setBackgroundColor(R.color.white)
        card1.setIconLayoutParams(300, 300, 0, 0, 0, 0)
        card2.setBackgroundColor(R.color.white)
        card2.setIconLayoutParams(300, 300, 0, 0, 0, 0)
        card3.setBackgroundColor(R.color.white)
        card3.setIconLayoutParams(300, 300, 0, 0, 0, 0)

        val pages = ArrayList<FancyWalkthroughCard>()
        pages.add(card1)
        pages.add(card2)
        pages.add(card3)
        for (card in pages) {
            card.setTitleColor(R.color.black)
            card.setDescriptionColor(R.color.black)
        }
        setFinishButtonTitle("Get Started")
        showNavigationControls(true)
        setColorBackground(R.color.red)
        setImageBackground(R.drawable.logo3)


        setInactiveIndicatorColor(R.color.grey_600)
        setActiveIndicatorColor(R.color.red)
        setOnboardPages(pages)


    }

    override fun onFinishButtonPressed() {
        startActivity(Intent(this@SplashActivity, YearTabbedActivity::class.java))

    }
}
