package com.optimus.devcolibrifinal.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.optimus.devcolibrifinal.R
import com.optimus.devcolibrifinal.di.Injector
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.viewmodels.DetailViewModel
import com.optimus.devcolibrifinal.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "BOOK_ID"
    }


    lateinit var detailViewModel: DetailViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        Injector.getAppComponent().inject(this)

        initViewModel()
        handleIntent()
    }

    private fun initViewModel() {
        detailViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        detailViewModel.handleBook().observe(this, Observer {
            updateViews(it)
        })
    }

    private fun updateViews(book: Book) {
        Glide.with(this)
            .load(book.imageUrl)
            .into(iv_detail_book_detail)

        tv_detail_book_title.text = book.title
        tv_detail_description.text = book.description
    }

    private fun handleIntent() {
        val id = intent.getIntExtra(EXTRA_ID,-1)
        detailViewModel.findBookById(id)
    }

}
