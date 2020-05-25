package com.optimus.devcolibrifinal.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.optimus.devcolibrifinal.R
import com.optimus.devcolibrifinal.adapters.BookAdapter
import com.optimus.devcolibrifinal.di.App
import com.optimus.devcolibrifinal.di.Injector
import com.optimus.devcolibrifinal.viewmodels.BookViewModel
import com.optimus.devcolibrifinal.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var bookViewModel: BookViewModel
    private lateinit var adapter:BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Injector.getAppComponent().inject(this)

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
        bookViewModel = ViewModelProviders.of(this, viewModelFactory).get(BookViewModel::class.java)
        bookViewModel.loadBooksData()
        bookViewModel.getBooks().observe(this, Observer {
            Log.e("M_MainActivity", "$it")
            adapter.updateData(it)
        })
    }

}
