package com.example.simplestoremanager.Product

import androidx.room.*

@Dao
interface ProductDao {

    @Insert
    fun insert(product: Product): Long

    @Delete
    fun delete(product: Product): Int

    @Update
    fun update(product: Product): Int

    @Query("SELECT * FROM Product")
    fun listAll(): Array<Product>
}