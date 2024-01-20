package com.app.mova.feature.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mova.feature.auth.model.SignInUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(email = email)
            }
        }
    }

    fun onPasswordChange(password: String) {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(password = password)
            }
        }
    }

    fun onCheckedChange(checked: Boolean) {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(isRememberChecked = checked)
            }
        }
    }

}