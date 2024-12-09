package com.example.data.datasource

import com.example.domain.model.User

interface UserDataSource {
    suspend fun fetchUser(userId: Int): User
}
