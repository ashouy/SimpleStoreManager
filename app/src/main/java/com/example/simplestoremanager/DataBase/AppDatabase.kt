package com.example.simplestoremanager.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplestoremanager.Product.Product
import com.example.simplestoremanager.Product.ProductDao

@Database(
    entities = [Product:: class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productDao(): ProductDao
}