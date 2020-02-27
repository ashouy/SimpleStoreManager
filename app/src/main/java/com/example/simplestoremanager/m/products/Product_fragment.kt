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
        var product2 = Product(10,"telha",200f)
        var product3 = Product(20,"rodo",45f)
        var product5 = Product(10,"alicate",200f)
        var product6 = Product(20,"arame",45f)
        var product7 = Product(10,"prego",200f)
        var product8 = Product(20,"parafuso",45f)
        var product9 = Product(10,"caixa",200f)
        var product10 = Product(20,"fio",45f)
        var testList = ArrayList<Product>()
        testList.add(product)
        testList.add(product2)
        testList.add(product3)
        testList.add(product5)
        testList.add(product6)
        testList.add(product7)
        testList.add(product8)
        testList.add(product9)
        testList.add(product10)
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
