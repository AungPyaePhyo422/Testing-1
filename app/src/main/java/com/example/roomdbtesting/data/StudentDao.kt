package com.example.roomdbtesting.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdbtesting.data.Student

@Dao
interface StudentDao {

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    fun insert(student : Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM student_table ORDER BY id ASC")
     fun getItem() : LiveData<List<Student>>

}