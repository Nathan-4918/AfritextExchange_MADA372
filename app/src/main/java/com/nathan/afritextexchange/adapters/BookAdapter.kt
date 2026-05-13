package com.nathan.afritextexchange.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathan.afritextexchange.R
import com.nathan.afritextexchange.activities.BookDetailActivity
import com.nathan.afritextexchange.models.Book

class BookAdapter(private val books: MutableList<Book>) :
RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvTitle: TextView = view.findViewById(R.id.tv_book_title)
        val tvAuthor: TextView = view.findViewById(R.id.tv_book_author)
        val tvPrice:  TextView = view.findViewById(R.id.tv_book_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.tvTitle.text  = book.title
        holder.tvAuthor.text = book.author
        holder.tvPrice.text  = "R %.2f".format(book.price)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BookDetailActivity::class.java).apply {
                putExtra("BOOK_TITLE",       book.title)
                putExtra("BOOK_AUTHOR",      book.author)
                putExtra("BOOK_PRICE",       book.price)
                putExtra("BOOK_CONDITION",   book.condition)
                putExtra("BOOK_DESCRIPTION", book.description)
                putExtra("BOOK_SELLER",      book.sellerName)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = books.size

    fun updateList(filtered: List<Book>) {
        books.clear()
        books.addAll(filtered)
        notifyDataSetChanged()
    }

}