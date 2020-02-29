package com.example.simplestoremanager.m.products

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplestoremanager.R
import com.example.simplestoremanager.m.MainActivity
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {
        lateinit var productName: String
        lateinit var productQuant: String
        lateinit var productPrice: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        actionBar?.setTitle("@String/add_product")


        bt_save_product.setOnClickListener {
            var i = Intent(this,MainActivity ::class.java)
            var b = Bundle()
            b.putString("NAME",product_name_edit_text.text.toString())
            b.putString("AMOUNT",product_amount_edit_text.text.toString())
            b.putString("PRICE",product_price_edit_text.text.toString())
            i.putExtra("PARAMS",b)
            setResult(Activity.RESULT_OK,i)
            finish()
        }

        bt_cancel_save_product.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

}
