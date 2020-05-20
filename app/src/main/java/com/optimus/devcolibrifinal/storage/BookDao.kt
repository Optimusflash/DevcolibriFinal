package com.optimus.devcolibrifinal.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import com.optimus.devcolibrifinal.model.Book
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Dmitriy Chebotar on 26.04.2020.
 */

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(books: List<Book>)

    @Query("DELETE FROM Book")
    fun deleteAll()

    @Query("SELECT * FROM Book")
    fun getAll(): LiveData<List<Book>>

    @Query("SELECT * FROM Book WHERE id = :id LIMIT 1")
    fun getBook(id: Int): LiveData<Book>

    @Transaction
    fun deleteAllAndInsert(list: List<Book>) {
        deleteAll()
        insertAll(list)
    }
}