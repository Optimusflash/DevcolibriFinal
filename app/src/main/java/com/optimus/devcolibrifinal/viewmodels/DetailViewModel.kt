package com.optimus.devcolibrifinal.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.repositories.BookRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dmitriy Chebotar on 26.04.2020.
 */
@Singleton
class DetailViewModel @Inject constructor(private val repository: BookRepository): ViewModel() {

    private val book = MutableLiveData<Book>()


    fun findBookById(id: Int) {
        repository.getBookLiveDataFromDb(id).observeForever {
            book.value = it
        }
    }

    fun handleBook() = book
}