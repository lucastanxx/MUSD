package com.example.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main6.*

class Main6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
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
        actionbar?.setDisplayHomeAsUpEnabled(true)
        val test = applicationContext as MovieDetails
        nameText.setText(test.getMovieName1())
        descriptionText.setText(test.getDescriptions1())
        releaseText.setText(test.getDate1())
        var language = test.getLanguage1()
        if (language == "English") {
            radioButton1.isChecked = true
        } else if (language == "Chinese") {
            radioButton2.isChecked = true
        } else if (language == "Malay") {
            radioButton3.isChecked = true
        } else {
            radioButton4.isChecked = true
        }
        if (test.getReason11()) {
            checkBox3.isChecked = true
            checkBox2.isChecked = true
        }
        if (test.getReason22()) {
            checkBox4.isChecked = true
            checkBox3.isChecked = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editmovie, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSave) {
            var isValid = true
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
                val i = Intent(this@Main6Activity, Main5Activity::class.java)
                startActivity(i)
            }
        } else {
            val i = Intent(this@Main6Activity, Main4Activity::class.java)
            startActivity(i)

        }
        return super.onOptionsItemSelected(item)
    }
}
