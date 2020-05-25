package com.optimus.devcolibrifinal.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optimus.devcolibrifinal.di.scopes.ActivityScope
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.repositories.BookRepository
import javax.inject.Inject

/**
 * Created by Dmitriy Chebotar on 26.04.2020.
 */
@ActivityScope
class DetailViewModel @Inject constructor(private val repository: BookRepository): ViewModel() {

    private val book = MutableLiveData<Book>()


    fun findBookById(id: Int) {
        repository.getBookLiveDataFromDb(id).observeForever {
            book.value = it
        }
    }

    fun handleBook() = book
}