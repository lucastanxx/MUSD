package com.example.movierater

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.android.synthetic.main.activity_main.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val actionbar = supportActionBar
        actionbar!!.title = "MovieRater"
        actionbar.setDisplayHomeAsUpEnabled(true)
        registerForContextMenu(reviewText)
        var movieObject = intent.getStringArrayExtra("THISISAMOVIENAME")
        movieObject.movieName
        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.reviewText){
            menu?.add(1,1001,1,"Add Review")
        }
    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val navigate = Intent(this, Main3Activity::class.java )
        if(item?.itemId == 1001){
            startActivity(navigate)
        }
        return super.onContextItemSelected(item)
    }
}
