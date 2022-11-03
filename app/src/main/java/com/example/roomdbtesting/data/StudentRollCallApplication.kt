package com.example.roomdbtesting.data

import android.app.Application

class StudentRollCallApplication : Application() {
    val database : RoomDataBase by lazy {
        RoomDataBase.getDatabase(this)
    }
}