package com.nathan.afritextexchange.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.databinding.ActivityEnquiryBinding
import com.nathan.afritextexchange.utils.ValidationUtils

class EnquiryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnquiryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnquiryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Send Enquiry"

        val sellerName = intent.getStringExtra("SELLER_NAME") ?: ""
        binding.sellerName = sellerName

        binding.btnSendMessage.setOnClickListener {
            val message = binding.tilMessage.editText?.text.toString().trim()
            if (!ValidationUtils.isNotEmpty(message)) {
                binding.tilMessage.error = getString(R.string.error_empty_field)
            } else {
                binding.tilMessage.error = null
                Toast.makeText(this, "Enquiry sent to $sellerName!", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}