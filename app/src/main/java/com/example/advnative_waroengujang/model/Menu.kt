package com.example.advnative_waroengujang.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Menu(
    @ColumnInfo(name="id")
    var id:String,
    @ColumnInfo(name="name")
    var name:String,
    @ColumnInfo(name="description")
    var description:String,
    @ColumnInfo(name="price")
    var price:String,
    @ColumnInfo(name="photo")
    var photo:String,
    @ColumnInfo(name="category")
    var category:String
)

