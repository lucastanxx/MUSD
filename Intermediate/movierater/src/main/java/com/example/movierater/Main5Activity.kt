package com.example.movierater

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main5.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val actionbar = supportActionBar
        actionbar!!.title = "MovieRater"
        actionbar.setDisplayHomeAsUpEnabled(true)
        registerForContextMenu(reviewText)
        val test = applicationContext as MovieDetails
        titleText.text = test.getMovieName1()
        overViewText.text = test.getDescriptions1()
        var gotReview = test.getReviews1()
        if(gotReview != ""){
            ratingBar2.rating = test.getStarss()
            reviewText.text = test.getReviews1()
            ratingBar2.visibility = View.VISIBLE
        }
        else{
            reviewText.text = "No reviews yet.\nLong press here to add your review"
        }
        languageText.text = test.getLanguage1()
        releaseText1.text = test.getDate1()
        var reasons = ""
        if (test.getReason11() == true) {
            reasons += "Violence"
        }
        if (test.getReason22() == true) {
            reasons += " Language used"
        }

        if (test.getSuitable1() == false) {
            suitableText.text = "Yes"
        } else {
            suitableText.text = "No(" + reasons + ")"
        }
//        button2.setOnClickListener({
//            var i = Intent(this, Main6Activity::class.java)
//            startActivity(i)
//        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.reviewText) {
            menu?.add(1, 1001, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val navigate = Intent(this, Main3Activity::class.java)
        if (item?.itemId == 1001) {
            startActivity(navigate)
        }
        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val i = Intent(this@Main5Activity, Main4Activity::class.java)
        startActivity(i)
        return super.onOptionsItemSelected(item)
    }
}
