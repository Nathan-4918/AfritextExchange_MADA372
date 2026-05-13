package com.nathan.afritextexchange.activities

import android.content.Intent
import android.content.LocusId
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.utils.ValidationUtils


class RegisterActivity : AppCompatActivity() {

    private lateinit var tilFullName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilStudentId: TextInputLayout
    private lateinit var tilPassword: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tilFullName = findViewById(R.id.til_full_name)
        tilEmail = findViewById(R.id.til_email)
        tilStudentId = findViewById(R.id.til_student_id)
        tilPassword = findViewById(R.id.til_password)

        findViewById<MaterialButton>(R.id.btn_sign_up).setOnClickListener {
            if (validateForm()) {
                Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }

        findViewById<android.widget.TextView>(R.id.tv_login_link).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true
        val  name = tilFullName.editText?.text.toString().trim()
        val email = tilEmail.editText?.text.toString().trim()
        val studentId = tilStudentId.editText?.text.toString().trim()
        val password = tilPassword.editText?.text.toString()

        if (!ValidationUtils.isNotEmpty(name)) {
            tilFullName.error = getString(R.string.error_empty_field); isValid = false
        } else { tilFullName.error = null }

        if (!ValidationUtils.isValidEmail(email)) {
            tilEmail.error = getString(R.string.error_invalid_email); isValid = false
        } else { tilEmail.error = null }

        if (!ValidationUtils.isNotEmpty(studentId)) {
            tilStudentId.error = getString(R.string.error_empty_field); isValid = false
        } else { tilStudentId.error = null }

        if (!ValidationUtils.isValidPassword(password)) {
            tilPassword.error = getString(R.string.error_short_password); isValid = false
        } else { tilPassword.error = null }

        return isValid
    }
}