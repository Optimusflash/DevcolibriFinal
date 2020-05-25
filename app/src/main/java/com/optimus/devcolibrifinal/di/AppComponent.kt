package com.optimus.devcolibrifinal.di

import com.optimus.devcolibrifinal.remote.BookRemoteService
import com.optimus.devcolibrifinal.repositories.BookRepository
import com.optimus.devcolibrifinal.storage.BookDao
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
@Singleton
@Component(modules = [RemoteModule::class, StorageModule::class])
interface AppComponent {
//    fun inject (repository: BookRepository)
//    fun inject (bookViewModel: BookViewModel)
//    fun inject (detailViewModel: DetailViewModel)
    fun bookService(): BookRemoteService
    fun bookDao(): BookDao
    fun bookRepository(): BookRepository
}