package com.example.agrilink.screens.login

import com.example.agrilink.data.LoginRepository

class LoginPresenter(
    private var view: LoginContract.View?,
    private val repository: LoginRepository
) : LoginContract.Presenter {

    override fun onLoginClicked(email: String, password: String) {

        if (email.trim().isEmpty()) {
            view?.showEmailError("Email cannot be empty.")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) {
            view?.showEmailError("Please enter a valid email address.")
            return
        }

        if (password.trim().isEmpty()) {
            view?.showPasswordError("Password cannot be empty.")
            return
        }

        if (password.length < 6) {
            view?.showPasswordError("Password must be at least 6 characters.")
            return
        }

        val isValid = repository.validateCredentials(email.trim(), password.trim())

        if (isValid) {
            view?.onLoginSuccess()
        } else {
            view?.onLoginFailure("Invalid email or password. Please try again.")
        }
    }

    override fun onDestroy() {
        view = null
    }
}
