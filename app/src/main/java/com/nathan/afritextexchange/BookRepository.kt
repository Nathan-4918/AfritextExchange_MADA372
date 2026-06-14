package com.nathan.afritextexchange

import com.nathan.afritextexchange.models.Book

object BookRepository {

    private var nextId = 5

    val books: MutableList<Book> = mutableListOf(
        Book(1, "Calculus: Early Transcendentals", "James Stewart",
            250.0, "Mathematics", "Good",
            "Minor highlighting in chapters 1-3.", "Thabo M.", "8th Edition"),
        Book(2, "Introduction to Algorithms", "Cormen et al.",
            320.0, "Computer Science", "Good",
            "No writing, spine slightly worn.", "Amara D.", "3rd Edition"),
        Book(3, "Principles of Economics", "Mankiw",
            180.0, "Economics", "Fair",
            "Some notes in margins.", "Kefilwe S.", "7th Edition"),
        Book(4, "Human Anatomy", "Gray's Anatomy",
            450.0, "Medicine", "Like New",
            "Used for one semester only.", "Sipho N.", "41st Edition"),
        Book(5, "Contract Law", "McKendrick",
            210.0, "Law", "Good",
            "Clean copy, no markings.", "Lerato B.", "2nd Edition"),
        Book(6, "Structural Analysis", "Hibbeler",
            280.0, "Engineering", "Fair",
            "Highlighted chapters 4-7.", "Kagiso T.", "9th Edition"),
        Book(7, "Linear Algebra", "Gilbert Strang",
            190.0, "Mathematics", "Good",
            "A few pencil notes.", "Naledi M.", "4th Edition"),
        Book(8, "Data Structures in Java", "Goodrich",
            300.0, "Computer Science", "Like New",
            "Barely used.", "Bongani D.", "6th Edition")
    )

    fun addBook(title: String, author: String, price: Double,
                subject: String, edition: String = "") {
        books.add(
            Book(
                id = nextId++,
                title = title,
                author = author,
                price = price,
                subject = subject,
                condition = "Good",
                description = "Listed by student seller.",
                sellerName = "You",
                edition = edition
            )
        )
    }
}