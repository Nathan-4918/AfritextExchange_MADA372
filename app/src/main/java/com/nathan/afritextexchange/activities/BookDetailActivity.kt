package com.nathan.afritextexchange.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.nathan.afritextexchange.R

class BookDetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Book Details"

        val title       = intent.getStringExtra("BOOK_TITLE") ?: ""
        val author      = intent.getStringExtra("BOOK_AUTHOR") ?: ""
        val price       = intent.getDoubleExtra("BOOK_PRICE", 0.0)
        val condition   = intent.getStringExtra("BOOK_CONDITION") ?: ""
        val description = intent.getStringExtra("BOOK_DESCRIPTION") ?: ""
        val seller      = intent.getStringExtra("BOOK_SELLER") ?: ""

        findViewById<TextView>(R.id.tv_detail_title).text       = title
        findViewById<TextView>(R.id.tv_detail_seller).text      = "Seller: $seller | Author: $author"
        findViewById<TextView>(R.id.tv_detail_price).text       = "R %.2f".format(price)
        findViewById<TextView>(R.id.tv_detail_condition).text   = "Condition: $condition"
        findViewById<TextView>(R.id.tv_detail_description).text = description

        findViewById<MaterialButton>(R.id.btn_send_enquiry).setOnClickListener {
            startActivity(Intent(this, EnquiryActivity::class.java).apply {
                putExtra("SELLER_NAME", seller)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}