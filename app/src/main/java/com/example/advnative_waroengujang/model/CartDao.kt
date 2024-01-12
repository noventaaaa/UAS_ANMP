package com.example.advnative_waroengujang.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cart:Cart)


    @Query("SELECT * FROM cart")
    fun selectAllCart(): List<Cart>

    @Update
    fun update (cart: Cart)

    @Delete
    fun deleteCart(cart:Cart)
}