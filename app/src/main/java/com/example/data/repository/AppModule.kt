package com.example.data.repository

import com.example.data.datasource.UserDataSource
import com.example.data.datasource.UserDataSourceImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.data.repository.UserRepository
import com.example.domain.usecase.GetUserUseCase
import com.example.domain.usecase.GetUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDataSource(): UserDataSource {
        return UserDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }

    @Provides
    @Singleton
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCaseImpl(userRepository)
    }
}
