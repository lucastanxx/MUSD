package com.example.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main4.*


class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.adv,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.miAddAdv){
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
//    private lateinit var listView ListView{
//        listView = findViewById<ListView>(R.id.movieListView)
//// 1
//        val adapter = MovieAdapter(this, movieListView)
//        listView.adapter = adapter
//// 2
//        val listItems = arrayOfNulls<String>(movieList.size)
//// 3
//        for (i in 0 until movieList.size) {
//            val movieList = movieList[i]
//            listItems[i] = movieList.title
//        }
//// 4
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
//        listView.adapter = adapter
//    }
}
