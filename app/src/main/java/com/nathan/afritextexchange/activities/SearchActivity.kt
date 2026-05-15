package com.nathan.afritextexchange.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputEditText
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.adapters.BookAdapter
import com.nathan.afritextexchange.models.Book

class SearchActivity : AppCompatActivity() {

    private lateinit var adapter: BookAdapter
    private lateinit var tvResultCount: TextView
    private lateinit var tvEmpty: TextView
    private lateinit var rvResults: RecyclerView

    private var currentQuery = ""
    private var currentSubject = "All"

    private val allBooks = listOf(
        Book(1, "Calculus: Early Transcendentals", "James Stewart",    250.0, "Mathematics",     "Good",     "Minor highlighting in chapters 1-3.", "Thabo M."),
        Book(2, "Introduction to Algorithms",       "Cormen et al.",    320.0, "Computer Science","Good",     "No writing, spine slightly worn.",    "Amara D."),
        Book(3, "Principles of Economics",          "Mankiw",           180.0, "Economics",       "Fair",     "Some notes in margins.",              "Kefilwe S."),
        Book(4, "Human Anatomy",                    "Gray's Anatomy",   450.0, "Medicine",        "Like New", "Used for one semester only.",         "Sipho N."),
        Book(5, "Contract Law",                     "McKendrick",       210.0, "Law",             "Good",     "Clean copy, no markings.",            "Lerato B."),
        Book(6, "Structural Analysis",              "Hibbeler",         280.0, "Engineering",     "Fair",     "Highlighted chapters 4-7.",           "Kagiso T."),
        Book(7, "Linear Algebra",                   "Gilbert Strang",   190.0, "Mathematics",     "Good",     "A few pencil notes.",                 "Naledi M."),
        Book(8, "Data Structures in Java",          "Goodrich",         300.0, "Computer Science","Like New", "Barely used.",                        "Bongani D.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Search"

        tvResultCount = findViewById(R.id.tv_result_count)
        tvEmpty       = findViewById(R.id.tv_empty)
        rvResults     = findViewById(R.id.rv_search_results)

        adapter = BookAdapter(allBooks.toMutableList())
        rvResults.layoutManager = LinearLayoutManager(this)
        rvResults.adapter = adapter

        updateResults()


        findViewById<TextInputEditText>(R.id.et_search).addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    currentQuery = s.toString().trim()
                    updateResults()
                }
            }
        )


        val filterPanel = findViewById<View>(R.id.hsv_filters)
        findViewById<MaterialButton>(R.id.btn_filter).setOnClickListener {
            filterPanel.visibility =
                if (filterPanel.visibility == View.GONE) View.VISIBLE else View.GONE
        }


        findViewById<ChipGroup>(R.id.chip_group_subjects).setOnCheckedStateChangeListener { group, checkedIds ->
            currentSubject = if (checkedIds.isEmpty()) {
                "All"
            } else {
                val chip = group.findViewById<Chip>(checkedIds[0])
                chip?.text.toString()
            }
            updateResults()
        }
    }

    private fun updateResults() {
        val filtered = allBooks.filter { book ->
            val matchesQuery = currentQuery.isEmpty() ||
                    book.title.contains(currentQuery, ignoreCase = true) ||
                    book.author.contains(currentQuery, ignoreCase = true) ||
                    book.subject.contains(currentQuery, ignoreCase = true)

            val matchesSubject = currentSubject == "All" ||
                    book.subject.equals(currentSubject, ignoreCase = true)

            matchesQuery && matchesSubject
        }

        adapter.updateList(filtered)

        if (filtered.isEmpty()) {
            rvResults.visibility     = View.GONE
            tvEmpty.visibility       = View.VISIBLE
            tvResultCount.text       = "No results"
        } else {
            rvResults.visibility     = View.VISIBLE
            tvEmpty.visibility       = View.GONE
            tvResultCount.text       = "${filtered.size} book${if (filtered.size != 1) "s" else ""} found"
        }
    }

    override fun onSupportNavigateUp(): Boolean { onBackPressed(); return true }
}