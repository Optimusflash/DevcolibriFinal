package com.optimus.devcolibrifinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.optimus.devcolibrifinal.R
import com.optimus.devcolibrifinal.model.Book
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.rv_book_sell.view.*


/**
 * Created by Dmitriy Chebotar on 20.04.2020.
 */
class BookAdapter(val listener: (bookId: Int) -> Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var books: MutableList<Book> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_book_sell, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }


    inner class BookViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView),
        LayoutContainer {
        override val containerView: View?
            get() = itemView

        init {
            itemView.setOnClickListener {
                val id = books[layoutPosition].id
                listener.invoke(id)
            }
        }

        fun bind(book: Book) {
            Glide.with(itemView)
                .load(book.imageUrl)
                .into(itemView.iv_book_picture)
            itemView.tv_book_title.text = book.title
        }
    }

    fun updateData(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }
}