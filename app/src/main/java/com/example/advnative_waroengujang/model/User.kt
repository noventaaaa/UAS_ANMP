package com.example.advnative_waroengujang.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class User (
    @ColumnInfo(name="name")
    var name:String,
    @ColumnInfo(name="username")
    var username:String,
    @ColumnInfo(name="password")
    var password:String
)