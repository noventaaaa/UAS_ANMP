package com.example.advnative_waroengujang.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cart:Cart)

//    @Query("SELECT * FROM todo ORDER BY priority DESC")
//    fun selectAllTodo(): List<Todo>

    //    @Query("SELECT * FROM WHERE is_done=0 todo ORDER BY priority DESC")
//    fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM cart")
    fun selectAllCart(): List<Cart>

//    @Query("SELECT * FROM cart WHERE uuid= :id")
//    fun selectTodo(id:Int): Cart

//    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
//    suspend fun update(title:String, notes:String, priority:Int, id:Int)
//
//    @Query("SELECT * FROM todo ORDER BY priority DESC")
//    //suspend fun selectAllTodo(): List<Todo>

    //cara lain untuk update
    @Update
    fun update (cart: Cart)

    @Delete
    fun deleteCart(cart:Cart)
}