package com.example.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.local.dao.User

@Entity
data class LoginEntity(
@PrimaryKey(autoGenerate = true) val userId: Int=0,
    val email: String?,
    val password: String?,
    val userName: String?,
)

fun LoginEntity.toDomain(): User {
    return User(
        uid = this.userId,
        email = this.email,
        name = this.userName,
        password = this.password
    )
}

fun LoginEntity.toEntity(): LoginEntity {
    return LoginEntity(
        userId = this.userId,
        email = this.email,
        password=this.password,
        userName= this.userName

    )
}

