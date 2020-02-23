package com.example.simplestoremanager.m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.simplestoremanager.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tool_bar = tool_bar
        setSupportActionBar(tool_bar)

        drawer = drawer_layout

        toggle = ActionBarDrawerToggle(
            this, drawer, tool_bar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer.addDrawerListener(toggle)

        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }
}
