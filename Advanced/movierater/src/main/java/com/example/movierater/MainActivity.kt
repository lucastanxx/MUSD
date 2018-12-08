package com.example.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
                val test = applicationContext as MovieDetails
                test.setMovieName1(nameText.text.toString())
                test.setDescriptions1(descriptionText.text.toString())
                test.setDate1(releaseText.text.toString())
                test.setLanguage1(language)
                test.setSuitable(suitable123)
                test.setReason11(checkBox2.isChecked)
                test.setReason22(checkBox4.isChecked)
                val i = Intent(this@MainActivity, Main5Activity::class.java)
                startActivity(i)
            } else {
                //do nothing
            }
            return super.onOptionsItemSelected(item)
        } else if (item?.itemId == R.id.miClear){
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



