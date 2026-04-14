package com.example.agrilink.utils

import android.app.Activity
import android.view.View
import android.widget.EditText
import android.widget.Toast

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun EditText.trimmedText(): String = text.toString().trim()

fun EditText.setFieldError(message: String) {
    error = message
    requestFocus()
}
