package com.example.advnative_waroengujang.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg menu: Menu)

    @Query("SELECT * FROM menu")
    fun selectAllMenu(): List<Menu>

    @Update
    fun update (menu: Menu)

    @Delete
    fun deleteMenu(menu:Menu)
}