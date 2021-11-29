package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entities.LoginEntity

@Dao
interface LoginDao {
    @Query("SELECT * FROM LoginEntity")
    fun getAll(): List<LoginEntity>

    @Query("SELECT * FROM LoginEntity")
    fun getLoginUsers(): List<LoginEntity>

    @Query("SELECT * FROM LoginEntity WHERE email LIKE :email and password LIKE :password" +
                      " LIMIT 1")
    fun getLoginUser(email: String,password: String): LoginEntity

    @Query("SELECT * FROM LoginEntity WHERE email LIKE :email " +
            " LIMIT 1")
    fun findByEmail(email: String): LoginEntity

     @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLoginUser(vararg users: LoginEntity)

    @Delete
    fun delete(user: LoginEntity)
}