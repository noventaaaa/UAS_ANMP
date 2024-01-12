package com.example.advnative_waroengujang.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Cart(
    @ColumnInfo(name="menu_name")
    var menu_name:String,
    @ColumnInfo(name="menu_price")
    var menu_price:String,
    @ColumnInfo(name="quantity")
    var quantity:String,
)
