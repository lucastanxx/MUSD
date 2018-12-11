package com.example.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val test = applicationContext as MovieList
        val position = intent.getIntExtra("position",0)
        var hi = test.getMovie().elementAt(position.toInt())
        var movieName = hi.getMovieName1()
        textView8.text = "Enter your review for the movie: "+movieName
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.miSubmit){
            val test = applicationContext as MovieList
            val position = intent.getIntExtra("position",0)
            var hi = test.getMovie().elementAt(position.toInt())
            hi.setStarss(ratingBar.rating)
            hi.setReviews1(editText.text.toString())
            val i = Intent(this, Main5Activity::class.java)
            i.putExtra("position",position)
            startActivity(i)
        }else{
            //do nothing
        }
        return super.onOptionsItemSelected(item)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
