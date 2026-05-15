package com.nathan.afritextexchange.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.adapters.BookAdapter
import com.nathan.afritextexchange.models.Book
import android.view.Menu
import android.view.MenuItem

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sampleBooks = getSampleBooks()

        val rvFeatured: RecyclerView = findViewById(R.id.rv_featured)
        rvFeatured.layoutManager = LinearLayoutManager(this)
        rvFeatured.adapter = BookAdapter(sampleBooks.take(2).toMutableList())

        val rvLatest: RecyclerView = findViewById(R.id.rv_latest)
        rvLatest.layoutManager = LinearLayoutManager(this)
        rvLatest.adapter = BookAdapter(sampleBooks.drop(2).toMutableList())

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_sell -> {
                    startActivity(Intent(this, AddListingActivity::class.java)); true
                }
                R.id.nav_messages -> true
                else -> true
            }
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun getSampleBooks(): List<Book> = listOf(
        Book(1, "Calculus: Early Transcendentals", "James Stewart", 250.0, "Mathematics", "Good", "Minor highlighting in chapters 1-3.", "Thabo M."),
        Book(2, "Introduction to Algorithms", "Cormen et al.", 320.0, "Computer Science", "Good", "No writing, spine slightly worn.", "Amara D."),
        Book(3, "Principles of Economics", "Mankiw", 180.0, "Economics", "Fair", "Some notes in margins.", "Kefilwe S."),
        Book(4, "Human Anatomy", "Gray's Anatomy", 450.0, "Medicine", "Like New", "Used for one semester only.", "Sipho N.")
    )

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}