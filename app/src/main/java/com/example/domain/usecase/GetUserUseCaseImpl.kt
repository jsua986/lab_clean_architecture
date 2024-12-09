package com.example.domain.usecase

import com.example.domain.model.User
import com.example.data.repository.UserRepository
import javax.inject.Inject

class GetUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUserUseCase {
    override suspend fun execute(userId: Int): User {
        return userRepository.getUserById(userId)
    }
}
