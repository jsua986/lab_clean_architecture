package com.example.data.repository


import com.example.domain.model.User
import com.example.data.repository.UserRepository
import com.example.data.datasource.UserDataSource
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun getUserById(userId: Int): User {
        return userDataSource.fetchUser(userId)
    }
}
