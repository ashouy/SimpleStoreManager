package com.example.simplestoremanager.Product

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product (
    var name: String,
    var price: Float

)
{@PrimaryKey(autoGenerate = true)
    var id: Int =0
}
