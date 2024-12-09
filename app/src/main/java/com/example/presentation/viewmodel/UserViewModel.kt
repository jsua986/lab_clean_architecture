package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun loadUser(userId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedUser = getUserUseCase.execute(userId)
                _user.value = fetchedUser
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
                _user.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }
}
