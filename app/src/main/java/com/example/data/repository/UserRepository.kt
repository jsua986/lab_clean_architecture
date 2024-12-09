package com.example.data.repository

import com.example.domain.model.User

interface UserRepository {
    suspend fun getUserById(userId: Int): User
}
