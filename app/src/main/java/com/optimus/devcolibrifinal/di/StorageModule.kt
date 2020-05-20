package com.optimus.devcolibrifinal.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.optimus.devcolibrifinal.storage.BookDao
import com.optimus.devcolibrifinal.storage.BookDatabase
import dagger.Module
import dagger.Provides

/**
 * Created by Dmitriy Chebotar on 14.05.2020.
 */

@Module
class StorageModule(private val applicationContext: Context) {

    @Provides
    fun provideDatabase(): BookDatabase {
        return Room.databaseBuilder(applicationContext, BookDatabase::class.java, "book_database")
            .build()
    }

    @Provides
    fun provideDao(bookDatabase: BookDatabase): BookDao {
        return bookDatabase.bookDao()
    }
}