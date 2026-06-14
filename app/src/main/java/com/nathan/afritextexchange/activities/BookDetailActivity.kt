package com.nathan.afritextexchange.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nathan.afritextexchange.databinding.ActivityBookDetailBinding
import com.nathan.afritextexchange.models.Book

class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Book Details"

        // Reconstruct Book from intent extras, then bind the whole object at once
        val book = Book(
            id          = 0,
            title       = intent.getStringExtra("BOOK_TITLE")       ?: "",
            author      = intent.getStringExtra("BOOK_AUTHOR")      ?: "",
            price       = intent.getDoubleExtra("BOOK_PRICE", 0.0),
            subject     = "",
            condition   = intent.getStringExtra("BOOK_CONDITION")   ?: "",
            description = intent.getStringExtra("BOOK_DESCRIPTION") ?: "",
            sellerName  = intent.getStringExtra("BOOK_SELLER")      ?: "",
            edition     = intent.getStringExtra("BOOK_EDITION")     ?: ""
        )

        // One line sets ALL the @{book.x} fields in the XML
        binding.book = book

        binding.btnSendEnquiry.setOnClickListener {
            startActivity(Intent(this, EnquiryActivity::class.java).apply {
                putExtra("SELLER_NAME", book.sellerName)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}