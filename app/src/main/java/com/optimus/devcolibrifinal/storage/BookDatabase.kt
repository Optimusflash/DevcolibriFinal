package com.optimus.devcolibrifinal.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.optimus.devcolibrifinal.model.Book

/**
 * Created by Dmitriy Chebotar on 26.04.2020.
 */
@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}