package com.nathan.afritextexchange.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.utils.ValidationUtils
class AddListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_listing)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add listing"

        val subjects = listOf("Mathematics", "Computer Science", "Economics", "Law", "Medicine", "Engineering", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, subjects)
        (findViewById<AutoCompleteTextView>(R.id.actv_subject)).setAdapter(adapter)

        val tilTitle   = findViewById<TextInputLayout>(R.id.til_book_title)
        val tilAuthor  = findViewById<TextInputLayout>(R.id.til_author)
        val tilPrice   = findViewById<TextInputLayout>(R.id.til_price)

        findViewById<MaterialButton>(R.id.btn_add_textbook).setOnClickListener {
            var valid = true

            if (!ValidationUtils.isNotEmpty(tilTitle.editText?.text.toString())) {
                tilTitle.error = getString(R.string.error_empty_field); valid = false
            } else tilTitle.error = null

            if (!ValidationUtils.isNotEmpty(tilAuthor.editText?.text.toString())) {
                tilAuthor.error = getString(R.string.error_empty_field); valid = false
            } else tilAuthor.error = null

            val priceText = tilPrice.editText?.text.toString()
            if (!ValidationUtils.isValidPrice(priceText)) {
                tilPrice.error = getString(R.string.error_invalid_price); valid = false
            } else tilPrice.error = null

            if (valid) {
                Toast.makeText(this, "Textbook listed successfully!", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}