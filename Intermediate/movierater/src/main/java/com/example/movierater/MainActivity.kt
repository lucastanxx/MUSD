package com.example.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import java.io.Serializable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkBox3.setOnCheckedChangeListener { _, _ ->
            if (checkBox3.isChecked) {
                checkBox2.visibility = View.VISIBLE
                checkBox4.visibility = View.VISIBLE
            } else {
                checkBox2.visibility = View.GONE
                checkBox4.visibility = View.GONE
                checkBox2.isChecked = false
                checkBox4.isChecked = false
            }
        }
        val actionbar = supportActionBar
        actionbar!!.title = "MovieRater"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addmovie, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        class MovieDetails(movieName: String, descriptions: String, date: String, language: String, agesuitable: Boolean, reviews: Int, reason1: Boolean, reason2: Boolean) : Serializable {
            var movieName: String
            var descriptions: String
            var date: String
            var language: String
            var agesuitable: Boolean
            var reviews: Int
            var reason1: Boolean
            var reason2: Boolean

            init {
                this.movieName = movieName
                this.descriptions = descriptions
                this.date = date
                this.language = language
                this.agesuitable = agesuitable
                this.reviews = reviews
                this.reason1 = reason1
                this.reason2 = reason2
            }
        }
        if (item?.itemId == R.id.miAdd) {
            var isValid = true
            if (nameText.text.isNullOrEmpty()) {
                nameText.setError("Field Empty")
                isValid = false
            }
            if (descriptionText.text.isNullOrEmpty()) {
                descriptionText.setError("Field Empty")
                isValid = false
            }
            if (releaseText.text.isNullOrEmpty()) {
                releaseText.setError("Field Empty")
                isValid = false
            }

            var language = "English"
            var suitable123 = true
            if (isValid) {
                if (radioButton1.isChecked()) {
                    language = "English"
                } else if (radioButton2.isChecked()) {
                    language = "Chinese"
                } else if (radioButton3.isChecked()) {
                    language = "Malay"
                } else if (radioButton4.isChecked()) {
                    language = "Tamil"
                }
                if (checkBox3.isChecked) {
                    //do nothing
                } else {
                    suitable123 = false
                }
                var thisIsAMovie = MovieDetails(nameText.text.toString(), descriptionText.text.toString(), releaseText.text.toString(), language, suitable123, 0, checkBox2.isChecked, checkBox4.isChecked)
                val i = Intent(this@MainActivity, Main5Activity::class.java)
                i.putExtra("THISISAMOVIE", thisIsAMovie)
                startActivity(i)
            } else {
                //do nothing
            }
            return super.onOptionsItemSelected(item)
        } else if (item?.itemId == R.id.miAdd){
            nameText.text.clear()
            descriptionText.text.clear()
            radioButton1.isChecked = true
            radioButton2.isChecked = false
            radioButton3.isChecked = false
            radioButton4.isChecked = false
            releaseText.text.clear()
            checkBox3.isChecked = false
            checkBox2.visibility = View.GONE
            checkBox4.visibility = View.GONE
            checkBox2.isChecked = false
            checkBox4.isChecked = false
            return super.onOptionsItemSelected(item)
        }
        else{
            finish()
            return super.onOptionsItemSelected(item)
        }
    }
}



