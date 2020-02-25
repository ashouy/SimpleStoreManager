package com.example.simplestoremanager.m.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simplestoremanager.R

class ProductAdapter(private val product_list: ArrayList<Product>): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val ProductViewHolder = LayoutInflater.from(parent.context).inflate(R.layout.layout_product,
            parent,false)

        return ProductViewHolder(ProductViewHolder)
    }

    override fun getItemCount() = product_list.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val current_product = product_list[position]

        holder.product_name.setText(current_product.name)
        holder.product_price.setText(current_product.price.toString())
        holder.product_quant.setText(current_product.quant.toString())
    }
}