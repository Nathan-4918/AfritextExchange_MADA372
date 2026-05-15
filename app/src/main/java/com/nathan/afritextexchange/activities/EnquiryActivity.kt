package com.nathan.afritextexchange.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.nathan.afritextexchange.R
class EnquiryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enquiry)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Send Enquiry"

        val sellerName = intent.getStringExtra("SELLER_NAME") ?: ""
        val etTo = findViewById<TextInputEditText>(R.id.et_to)
        etTo.setText(sellerName)

        val tilMessage = findViewById<TextInputLayout>(R.id.til_message)

        findViewById<MaterialButton>(R.id.btn_send_message).setOnClickListener {
            val message = tilMessage.editText?.text.toString().trim()
            if (message.isEmpty()) {
                tilMessage.error = getString(R.string.error_empty_field)
            } else {
                tilMessage.error = null
                Toast.makeText(this, "Enquiry sent to $sellerName!", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}