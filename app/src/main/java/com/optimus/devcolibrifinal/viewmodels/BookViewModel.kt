package com.optimus.devcolibrifinal.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.repositories.BookRepository
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dmitriy Chebotar on 20.04.2020.
 */
class BookViewModel : ViewModel() {

    private val repository = BookRepository()
    private val books = MutableLiveData<List<Book>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        Log.e("M_BookViewModel", "init 1")
        repository.getListBookLiveDataFromDb().observeForever {
            it ?: return@observeForever
            books.value = it
            Log.e("M_BookViewModel", "forever")
        }
    }

    fun loadBooksData(){
        val disposable = repository.loadBooks()
            .flatMapCompletable {
                repository.saveBookToDb(it)
                return@flatMapCompletable Completable.complete()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onLoadComplete, ::onErrorLoad)

        compositeDisposable.add(disposable)
    }

    private fun onLoadComplete() {
        Log.e("M_BookViewModel", "Complete")
    }

    private fun onErrorLoad(throwable: Throwable) {
        Log.e("M_BookViewModel", "Error")
    }

    fun getBooks(): LiveData<List<Book>>{
        return books
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}