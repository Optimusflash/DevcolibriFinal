package com.optimus.devcolibrifinal.repositories

import android.util.Log
import com.optimus.devcolibrifinal.di.App
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.remote.BookRemoteService
import com.optimus.devcolibrifinal.storage.BookDao
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.math.log

/**
 * Created by Dmitriy Chebotar on 20.04.2020.
 */
class BookRepository {
    @Inject
    lateinit var api: BookRemoteService

    @Inject
    lateinit var db: BookDao

    init {
        App.component.inject(this)
    }

    fun getListBookLiveDataFromDb() = db.getAll()

    fun getBookLiveDataFromDb(id: Int)= db.getBook(id)

    fun saveBookToDb(list: List<Book>) = db.deleteAllAndInsert(list)

    fun loadBooks() = api.loadBooks()


}