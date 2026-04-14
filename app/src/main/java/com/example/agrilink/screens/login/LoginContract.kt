package com.example.agrilink.screens.login

interface LoginContract {

    interface View {
        fun onLoginSuccess()
        fun onLoginFailure(message: String)
        fun showEmailError(message: String)
        fun showPasswordError(message: String)
    }

    interface Presenter {
        fun onLoginClicked(email: String, password: String)
        fun onDestroy()
    }
}
