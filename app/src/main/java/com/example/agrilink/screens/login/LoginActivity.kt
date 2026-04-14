package com.example.agrilink.screens.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.agrilink.R
import com.example.agrilink.data.LoginRepository
import com.example.agrilink.utils.setFieldError
import com.example.agrilink.utils.showToast
import com.example.agrilink.utils.trimmedText

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginContract.Presenter
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        presenter = LoginPresenter(
            view = this,
            repository = LoginRepository()
        )

        btnLogin.setOnClickListener {
            presenter.onLoginClicked(
                email = etEmail.trimmedText(),
                password = etPassword.trimmedText()
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onLoginSuccess() {
        showToast("Welcome to AgriLink!")
    }

    override fun onLoginFailure(message: String) {
        showToast(message)
    }

    override fun showEmailError(message: String) {
        etEmail.setFieldError(message)
    }

    override fun showPasswordError(message: String) {
        etPassword.setFieldError(message)
    }
}
