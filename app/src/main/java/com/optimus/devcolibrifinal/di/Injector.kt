package com.optimus.devcolibrifinal.di

import android.app.Application
import android.content.Context
import com.optimus.devcolibrifinal.di.components.AppComponent
import com.optimus.devcolibrifinal.di.components.BookDetailComponent
import com.optimus.devcolibrifinal.di.components.BookListComponent
import com.optimus.devcolibrifinal.di.components.DaggerAppComponent
import com.optimus.devcolibrifinal.di.modules.RemoteModule
import com.optimus.devcolibrifinal.di.modules.StorageModule

/**
 * Created by Dmitriy Chebotar on 25.05.2020.
 */
class Injector {
    companion object {
        private lateinit var appComponent: AppComponent
        private var bookListComponent: BookListComponent? = null
        private var bookDetailComponent: BookDetailComponent? = null

        fun init(applicationContext: Context) {
            appComponent = DaggerAppComponent.builder()
                .remoteModule(RemoteModule())
                .storageModule(StorageModule(applicationContext))
                .build()
        }

        fun getBookListComponent(): BookListComponent {
            if (bookListComponent == null) {
                bookListComponent = appComponent.addBookListComponent()
            }
            return bookListComponent as BookListComponent
        }

        fun destroyBookListComponent() {
            bookListComponent = null
        }

        fun getBookDetailComponent(): BookDetailComponent {
            if (bookDetailComponent == null) {
                bookDetailComponent = appComponent.addBookDetailComponent()
            }
            return bookDetailComponent as BookDetailComponent
        }

        fun destroyBookDetailComponent() {
            bookDetailComponent = null
        }
    }
}
