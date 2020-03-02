package com.example.simplestoremanager.m

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.simplestoremanager.R
import com.example.simplestoremanager.m.clients.Client_fragment
import com.example.simplestoremanager.m.products.AddProductActivity
import com.example.simplestoremanager.m.products.Product
import com.example.simplestoremanager.m.products.Product_fragment
import com.example.simplestoremanager.m.settings.Settings_fragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit private var productDataBase: DatabaseReference
    lateinit var drawer: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    val products = ArrayList<Product>()
    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productDataBase = FirebaseDatabase.getInstance().getReference()

        var tool_bar = main_tool_bar
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

        getProducts()

        replace(true)
    }

    private fun replace(product: Boolean){
        if(product) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmaent_Container,
                Product_fragment(products)
            ).commit()
        }else
        {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmaent_Container,
                Client_fragment(/*Clients*/)
            ).commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var b = data?.getBundleExtra("PARAMS")
        when (resultCode) {
            Activity.RESULT_OK -> {
                saveNewProduct(
                    b!!.getString("NAME", "default"),
                    b.getString("AMOUNT", "deafult"),
                    b.getString("PRICE", "default")
                )
                getProducts()
                replace(true)
            }
        }
    }

    private fun getProducts() {
        val productQuery = productDataBase.child("Products")

        productQuery.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.i("cancel", "canceled")
            }

            override fun onDataChange(p0: DataSnapshot) {
                products.clear()
                if (p0.exists()) {
                    for (child in p0.children) {
                        var product = child.getValue(Product::class.java)
                        products.add(product!!)
                        Log.i("listt", "name: " + product.name)
                        Log.i("listt", "amount: " + product.quant)
                    }
                }
            }
        })
    }

    private fun saveNewProduct(name: String, amount: String, price: String) {
        var id = productDataBase.push().key
        var p = Product(id, name, amount, price)
        productDataBase.child("Products").child(id!!).setValue(p)
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
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
                    replace(true)
                    )
            R.id.clients_menu -> (
                    replace(false)
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

    fun onClickFab(view: View) {
        var i = Intent(this, AddProductActivity::class.java)
        startActivityForResult(i, 1)
    }
}
