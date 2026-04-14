package com.example.agrilink.screens.login

import com.example.agrilink.AgriLinkApplication

class LoginModel(private val app: AgriLinkApplication) {

    fun authenticate(email: String, pass: String): String? {
        return when {
            email.isEmpty() -> "Email cannot be empty"
            pass.isEmpty() -> "Password cannot be empty"
            else -> null
        }
    }

    fun isCorrectPassword(password: String): Boolean {
        val regUser = app.getUserInfo()
        return password == regUser.password
    }

    fun isCorrectEmail(email: String): Boolean {
        val regUser = app.getUserInfo()
        return email == regUser.email
    }
}
