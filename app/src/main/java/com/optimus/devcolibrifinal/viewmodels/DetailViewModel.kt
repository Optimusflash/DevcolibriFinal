package com.optimus.devcolibrifinal.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.repositories.BookRepository

/**
 * Created by Dmitriy Chebotar on 26.04.2020.
 */
class DetailViewModel: ViewModel() {

    private val repository = BookRepository()
    private val book = MutableLiveData<Book>()

    fun findBookById(id: Int) {
        repository.getBookLiveDataFromDb(id).observeForever {
            book.value = it
        }
    }

    fun handleBook() = book
}