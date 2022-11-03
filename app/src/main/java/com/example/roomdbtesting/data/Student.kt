package com.example.roomdbtesting.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "first_name") val first_name : String,
    @ColumnInfo(name = "last_name") val last_name : String,
    @ColumnInfo(name = "age") val age : String

)
