package com.example.advnative_waroengujang.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg cart:Cart)

    @Query("SELECT * FROM user")
    fun selectAllUser(): List<User>

    @Update
    fun update (user: User)

    @Delete
    fun deleteUser(user: User)
}