package com.example.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main4.*


class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        registerForContextMenu(middleText)
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.middleText){
            menu?.add(1,1001,1,"Add")
        }
    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val navigate = Intent(this, MainActivity::class.java )
        if(item?.itemId == 1001){
            startActivity(navigate)
        }
        return super.onContextItemSelected(item)
    }

}
