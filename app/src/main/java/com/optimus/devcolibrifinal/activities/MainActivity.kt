package com.optimus.devcolibrifinal.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.optimus.devcolibrifinal.R
import com.optimus.devcolibrifinal.adapters.BookAdapter
import com.optimus.devcolibrifinal.adapters.ItemTouchCallback
import com.optimus.devcolibrifinal.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var adapter:BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initViews()

    }

    private fun initViews() {
        adapter = BookAdapter { bookId->
            //Toast.makeText(this, " $bookId", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.EXTRA_ID,bookId)
            startActivity(intent)
        }
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    private fun initViewModel() {
        bookViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        bookViewModel.loadBooksData()
        bookViewModel.getBooks().observe(this, Observer {
            Log.e("M_MainActivity", "$it")
            adapter.updateData(it)
        })
    }
}
