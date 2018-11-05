package com.example.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


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
        button.setOnClickListener {
            var counter = 0
            if (nameText.text.isNullOrEmpty()) {
                nameText.setError("Field Empty")
            } else {
                counter++
            }
            if (descriptionText.text.isNullOrEmpty()) {
                descriptionText.setError("Field Empty")
            } else {
                counter++
            }
            if (releaseText.text.isNullOrEmpty()) {
                releaseText.setError("Field Empty")
            } else {
                counter++
            }
            if (counter == 3) {
                var language = "English"
                if (radioButton1.isChecked()) {
                    language = "English"
                } else if (radioButton2.isChecked()) {
                    language = "Chinese"
                } else if (radioButton3.isChecked()) {
                    language = "Malay"
                } else if (radioButton4.isChecked()) {
                    language = "Tamil"
                }
                var languageToast = "Language = " + language
                var suitable = "true"
                if (checkBox3.isChecked) {
                    suitable = "true"
                } else {
                    suitable = "false"
                }
                var suitableText = "Not suitable for all ages = " + suitable
                var option1 = ""
                if (checkBox2.isChecked()) {
                    option1 = "Violence"
                }
                var option2 = ""
                if (checkBox4.isChecked()) {
                    option2 = "Language"
                }
                var reasons = ""
                if (checkBox3.isChecked()) {
                    reasons = "Reason : \n" + option2 + "\n" + option1
                } else {
                    reasons = ""
                }
                Toast.makeText(this, "Title = " + nameText.text + "\n" + "Overview = " + descriptionText.text + "\n" + "Release Date = " + releaseText.text + "\n" + languageToast + "\n" + suitableText + "\n" + reasons, Toast.LENGTH_LONG).show()
            }
        }
    }
}

