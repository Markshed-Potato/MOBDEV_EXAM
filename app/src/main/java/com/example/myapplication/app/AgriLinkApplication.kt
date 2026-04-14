package com.example.agrilink

import android.app.Application

data class UserInfo(val email: String, val password: String)

class AgriLinkApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    fun getUserInfo(): UserInfo {
        return UserInfo(
            email = "farmer@agrilink.com",
            password = "agri1234"
        )
    }
}
