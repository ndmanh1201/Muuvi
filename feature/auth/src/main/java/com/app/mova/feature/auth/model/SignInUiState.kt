package com.app.mova.feature.auth.model

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val isRememberChecked: Boolean = false,
)