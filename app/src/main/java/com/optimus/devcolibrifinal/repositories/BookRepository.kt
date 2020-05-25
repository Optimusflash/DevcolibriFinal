package com.optimus.devcolibrifinal.repositories

import com.optimus.devcolibrifinal.di.App
import com.optimus.devcolibrifinal.model.Book
import com.optimus.devcolibrifinal.remote.BookRemoteService
import com.optimus.devcolibrifinal.storage.BookDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dmitriy Chebotar on 20.04.2020.
 */
@Singleton
class BookRepository @Inject constructor(private val api: BookRemoteService, private val db: BookDao) {

    fun getListBookLiveDataFromDb() = db.getAll()

    fun getBookLiveDataFromDb(id: Int)= db.getBook(id)

    fun saveBookToDb(list: List<Book>) = db.deleteAllAndInsert(list)

    fun loadBooks() = api.loadBooks()


}