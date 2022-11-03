package com.example.roomdbtesting.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

import kotlinx.coroutines.launch
import com.example.roomdbtesting.data.Student

class StudentViewModel(private val studentDao: StudentDao) : ViewModel(){

     private fun insertStudent(student: Student){
            studentDao.insert(student)

    }

    private fun getNewStudentEntity(first_name : String, last_name : String, age : String): Student {
        return Student(0, first_name, last_name, age)
    }

    fun addNewItem(first_name : String, last_name : String, age : String){
        val newStudent = getNewStudentEntity(first_name, last_name, age)
        insertStudent(newStudent)
    }


}

class StudentViewModelFactory(private val studentDao: StudentDao) : ViewModelProvider.AndroidViewModelFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java)){

            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(studentDao) as T

        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }
}