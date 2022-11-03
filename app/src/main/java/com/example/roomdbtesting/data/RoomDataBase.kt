package com.example.roomdbtesting.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database( entities = [Student::class], version = 1, exportSchema = false )
abstract class RoomDataBase : RoomDatabase() {

    abstract fun studentDao() : StudentDao

    companion object {

        @Volatile
        private var INSTANCE : RoomDataBase? = null

        fun getDatabase(context : Context) : RoomDataBase{

            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "student_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }

    }


}