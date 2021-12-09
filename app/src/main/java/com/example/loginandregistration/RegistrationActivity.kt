package com.example.loginandregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.app.Activity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.loginandregistration.databinding.ActivityRegistrationBinding
import org.w3c.dom.Text

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)

        Toast.makeText(this, "user: $username pwd $password", Toast.LENGTH_SHORT).show()


        binding.buttonToReturn.setOnClickListener {

            if(!RegistrationUtil.validateUsername(binding.editTextUsername.text.toString())) {
                Toast.makeText(this, "username is too short", Toast.LENGTH_SHORT).show()
            }
            if(!RegistrationUtil.validateName(binding.editTextName.text.toString())) {
                Toast.makeText(this, "name must be greater than 2 characters", Toast.LENGTH_SHORT).show()
            }
            if(!RegistrationUtil.validatePassword(binding.editTextPassword.text.toString(),
                    binding.editTextPasswordConfirm.text.toString())) {
                Toast.makeText(this, "password invalid or does not match", Toast.LENGTH_SHORT).show()
            }
            if(!RegistrationUtil.validateEmail(binding.editTextEmailAddress.text.toString())) {
                Toast.makeText(this, "email not valid", Toast.LENGTH_SHORT).show()
            }

            var returnToLoginIntent = Intent().apply {
                putExtra(LoginActivity.EXTRA_USERNAME, binding.editTextUsername.toString())
                putExtra(LoginActivity.EXTRA_PASSWORD, binding.editTextPassword.toString())
            }
            setResult(RESULT_OK, returnToLoginIntent)
            finish()
        }

    }
}