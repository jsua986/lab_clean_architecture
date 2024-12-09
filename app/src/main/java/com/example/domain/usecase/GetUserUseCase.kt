package com.example.domain.usecase

import com.example.domain.model.User

interface GetUserUseCase {
    suspend fun execute(userId: Int): User
}
