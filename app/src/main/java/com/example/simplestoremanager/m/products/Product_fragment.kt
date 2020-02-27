package com.example.simplestoremanager.m.products


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.simplestoremanager.R
import kotlinx.android.synthetic.main.fragment_product.*

/**
 * A simple [Fragment] subclass.
 */
class Product_fragment: Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var product = Product(20,"tijolo",45f)
        var testList = ArrayList<Product>()
        testList.add(product)

        product_recycler_view.adapter = ProductAdapter(testList!!)
        product_recycler_view.layoutManager = LinearLayoutManager(activity)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }



}
