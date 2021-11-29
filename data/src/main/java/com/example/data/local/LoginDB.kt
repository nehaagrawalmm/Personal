package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.local.dao.LoginDao
import com.example.data.local.entities.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LoginDB : RoomDatabase() {
    abstract fun loginDao(): LoginDao


    companion object {
        const val DB_NAME = "login_db"
    }
}

