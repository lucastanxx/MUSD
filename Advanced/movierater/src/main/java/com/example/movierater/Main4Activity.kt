package com.example.movierater

import android.app.Application
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_main4.*


class Main4Activity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        registerForContextMenu(movieListView)
        val test = applicationContext as MovieList
        if(test.getMovie().isNotEmpty()){
            val adapter = MovieAdapter1(this,test.getMovie())
            movieListView.adapter=adapter
        }
    }
    class MovieAdapter1(private val context: Context,
                        private val dataSource: ArrayList<MovieDetails>) : BaseAdapter() {

        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //1
        override fun getCount(): Int {
            return dataSource.size
        }

        //2
        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val rowView = inflater.inflate(R.layout.listview, parent, false)
            val titleTextView = rowView.findViewById(R.id.textView13) as TextView
            val movie = getItem(position) as MovieDetails
            titleTextView.text = movie.getMovieName1()

            return rowView
        }

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if (v?.id == R.id.movieListView){
            menu?.add(1,1001,1,"Edit")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
        if(item?.itemId == 1001){
            val i = Intent(this, Main6Activity::class.java)
            i.putExtra("position",info.id.toInt())
            startActivity(i)
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.adv,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.miAddAdv){
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }
}
