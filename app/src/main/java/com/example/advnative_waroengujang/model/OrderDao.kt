package com.example.advnative_waroengujang.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg order: Order)

    @Query("SELECT * FROM order")
    fun selectAllOrder(): List<Order>

    @Update
    fun update (order: Order)

    @Delete
    fun deleteOrder(order: Order)
}