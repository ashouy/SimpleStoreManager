package com.example.simplestoremanager.m.products

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_product.view.*

class ProductViewHolder(productView: View): RecyclerView.ViewHolder(productView) {
    val product_quant = productView.product_quant
    val product_name = productView.product_name
    val product_price = productView.product_price
}