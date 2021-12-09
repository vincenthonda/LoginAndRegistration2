package com.example.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    @Test
    fun validatePassword_empty_password_returnsFalse() {
        val result = RegistrationUtil.validatePassword("","")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_returnsFalse() {
        val result = RegistrationUtil.validatePassword("ABFHSK123.","dfsj123.l")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_hasNocapital_returnsFalse() {
        val result = RegistrationUtil.validatePassword("abs234edljf","abs234edljf")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_lessthan8digits_returnsFalse() {
        val result = RegistrationUtil.validatePassword("Abc123.","Abc123.")
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_noNumber_returnsFalse() {
        val result = RegistrationUtil.validatePassword("asdfghjklQ","asfdghjklQ")
        assertThat(result).isFalse()
    }

}