package com.nathan.afritextexchange.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nathan.afritextexchange.BookRepository
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.adapters.BookAdapter
import com.nathan.afritextexchange.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var featuredAdapter: BookAdapter
    private lateinit var latestAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        featuredAdapter = BookAdapter(BookRepository.books.take(2).toMutableList())
        binding.rvFeatured.layoutManager = LinearLayoutManager(this)
        binding.rvFeatured.adapter = featuredAdapter

        latestAdapter = BookAdapter(BookRepository.books.drop(2).toMutableList())
        binding.rvLatest.layoutManager = LinearLayoutManager(this)
        binding.rvLatest.adapter = latestAdapter

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_sell -> {
                    startActivity(Intent(this, AddListingActivity::class.java))
                    true
                }
                else -> true
            }
        }
    }

    override fun onResume() {
        super.onResume()
        featuredAdapter.updateList(BookRepository.books.take(2))
        latestAdapter.updateList(BookRepository.books.drop(2))
    }

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