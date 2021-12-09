package com.example.loginandregistration

import android.widget.Toast

object RegistrationUtil {

    var usernameList: List<String> = listOf("iphonelover333", "playboicartilover322", "ilovejuancarlosbravo",
        "twitter")

    fun validateEmail(email: String) : Boolean {
        if (email.indexOf("@") < email.indexOf(".com")) {
            return true
        }
        return false
    }
    fun validatePassword(password: String, confirmPassword: String) : Boolean {
        if (password.length < 8 ||password.indexOf("1") == -1) {
            return false
        }
        for (i in password) {
            if (!i.isLowerCase()) {
                return false
            }
        }
        if (password != confirmPassword) {
            return false
        }
        return true
    }
    fun validateName(name: String) : Boolean {
        return name.length >= 2
    }

    fun validateUsername(username: String) : Boolean {
        if (usernameList.indexOf(username) != -1) {
            return false
        }
        else return username.length > 3
    }
}