package com.example.advnative_waroengujang.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class Order (
    @ColumnInfo(name="table_number")
    var table_number:String,
    @ColumnInfo(name="total_price")
    var total_price:String,
    @ColumnInfo(name="duration")
    var duration:String,
    @ColumnInfo(name="detail_order")
    var detail_order:String
)