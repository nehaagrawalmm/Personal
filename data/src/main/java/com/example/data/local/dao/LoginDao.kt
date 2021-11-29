package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.local.entities.LoginEntity

@Dao
interface LoginDao {
    @Query("SELECT * FROM LoginEntity")
    fun getAll(): List<LoginEntity>

    @Query("SELECT * FROM LoginEntity")
    fun getLoginUsers(): List<LoginEntity>

    @Query("SELECT * FROM LoginEntity WHERE email LIKE :email " +
            " LIMIT 1")
    fun findByEmail(email: String): LoginEntity

    @Insert
    fun insertAll(vararg users: LoginEntity)

    @Delete
    fun delete(user: LoginEntity)
}