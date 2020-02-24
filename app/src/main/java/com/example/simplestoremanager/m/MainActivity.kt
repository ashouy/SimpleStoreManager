package com.example.simplestoremanager.m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.simplestoremanager.R
import com.example.simplestoremanager.m.clients.Client_fragment
import com.example.simplestoremanager.m.products.Product_fragment
import com.example.simplestoremanager.m.settings.Settings_fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var drawer: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tool_bar = tool_bar
        setSupportActionBar(tool_bar)

        drawer = drawer_layout

        var nav_view = nav_view
        nav_view.setNavigationItemSelectedListener(this)

        toggle = ActionBarDrawerToggle(
            this, drawer, tool_bar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer.addDrawerListener(toggle)

        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmaent_Container,
                Product_fragment()
            ).commit()
            nav_view.setCheckedItem(R.id.products_menu)
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.products_menu -> (
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragmaent_Container,
                        Product_fragment()
                    ).commit()
                    )
            R.id.clients_menu -> (
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragmaent_Container,
                        Client_fragment()
                    ).commit()
                    )
            R.id.setting_menu -> (
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragmaent_Container,
                        Settings_fragment()
                    ).commit()
                    )

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
