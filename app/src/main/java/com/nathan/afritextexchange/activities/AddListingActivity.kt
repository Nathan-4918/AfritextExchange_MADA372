package com.nathan.afritextexchange.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nathan.afritextexchange.BookRepository
import com.nathan.afritextexchange.databinding.ActivityAddListingBinding
import com.nathan.afritextexchange.utils.ValidationUtils

class AddListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add Listing"

        // Subject dropdown
        val subjects = listOf("Mathematics", "Computer Science", "Economics",
            "Law", "Medicine", "Engineering", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, subjects)
        (binding.tilSubject.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        binding.btnAddTextbook.setOnClickListener {
            if (validateAndSubmit()) {
                Toast.makeText(this, "Textbook listed successfully!", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun validateAndSubmit(): Boolean {
        var valid = true

        val title   = binding.tilBookTitle.editText?.text.toString().trim()
        val author  = binding.tilAuthor.editText?.text.toString().trim()
        val price   = binding.tilPrice.editText?.text.toString().trim()
        val subject = binding.tilSubject.editText?.text.toString().trim()

        // Validate using binding to show inline errors
        if (!ValidationUtils.isNotEmpty(title)) {
            binding.tilBookTitle.error = getString(com.nathan.afritextexchange.R.string.error_empty_field)
            valid = false
        } else {
            binding.tilBookTitle.error = null
        }

        if (!ValidationUtils.isNotEmpty(author)) {
            binding.tilAuthor.error = getString(com.nathan.afritextexchange.R.string.error_empty_field)
            valid = false
        } else {
            binding.tilAuthor.error = null
        }

        if (!ValidationUtils.isValidPrice(price)) {
            binding.tilPrice.error = getString(com.nathan.afritextexchange.R.string.error_invalid_price)
            valid = false
        } else {
            binding.tilPrice.error = null
        }

        // If all valid, save to the shared repository
        if (valid) {
            BookRepository.addBook(
                title   = title,
                author  = author,
                price   = price.toDouble(),
                subject = subject.ifEmpty { "Other" }
            )
        }

        return valid
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}