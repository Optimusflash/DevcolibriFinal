package com.optimus.devcolibrifinal.di.modules

import android.content.Context
import androidx.room.Room
import com.optimus.devcolibrifinal.storage.BookDao
import com.optimus.devcolibrifinal.storage.BookDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dmitriy Chebotar on 14.05.2020.
 */

@Module
class StorageModule(private val applicationContext: Context) {

    @Provides
    @Singleton
    fun provideDatabase(): BookDatabase {
        return Room.databaseBuilder(applicationContext, BookDatabase::class.java, "book_database")
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(bookDatabase: BookDatabase): BookDao {
        return bookDatabase.bookDao()
    }
}