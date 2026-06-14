package com.nathan.afritextexchange.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nathan.afritextexchange.activities.BookDetailActivity
import com.nathan.afritextexchange.databinding.ItemBookBinding
import com.nathan.afritextexchange.models.Book

class BookAdapter(private val books: MutableList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        // Data binding — sets @{book.title}, @{book.author}, @{book.price} in XML
        holder.binding.book = book
        holder.binding.executePendingBindings()

        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, BookDetailActivity::class.java).apply {
                putExtra("BOOK_TITLE",       book.title)
                putExtra("BOOK_AUTHOR",      book.author)
                putExtra("BOOK_PRICE",       book.price)
                putExtra("BOOK_CONDITION",   book.condition)
                putExtra("BOOK_DESCRIPTION", book.description)
                putExtra("BOOK_SELLER",      book.sellerName)
                putExtra("BOOK_EDITION",     book.edition)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = books.size

    fun updateList(newList: List<Book>) {
        books.clear()
        books.addAll(newList)
        notifyDataSetChanged()
    }
}