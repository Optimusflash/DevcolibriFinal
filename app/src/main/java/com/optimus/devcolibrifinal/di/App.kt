package com.optimus.devcolibrifinal.di

import android.app.Application
import com.facebook.stetho.Stetho
import com.optimus.devcolibrifinal.di.components.AppComponent
import com.optimus.devcolibrifinal.di.components.BookDetailComponent
import com.optimus.devcolibrifinal.di.components.BookListComponent
import com.optimus.devcolibrifinal.di.components.DaggerAppComponent
import com.optimus.devcolibrifinal.di.modules.RemoteModule
import com.optimus.devcolibrifinal.di.modules.StorageModule

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
class App: Application() {

    companion object{
        lateinit var appComponent: AppComponent
        lateinit var bookListComponent: BookListComponent
        lateinit var bookDetailComponent: BookDetailComponent
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        initAppComponent()
        initBookListComponent()
        initBookDetailComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .storageModule(StorageModule(this))
            .build()
    }

    private fun initBookListComponent() {
         bookListComponent = appComponent.addBookListComponent()

    }

    private fun initBookDetailComponent(){
//        bookDetailComponent = DaggerBookDetailComponent.builder()
//            .appComponent(appComponent)
//            .build()
        bookDetailComponent = appComponent.addBookDetailComponent()
    }
}