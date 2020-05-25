package com.optimus.devcolibrifinal.di

import android.app.Application
import com.facebook.stetho.Stetho

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
        bookListComponent = DaggerBookListComponent.builder()
            .appComponent(appComponent)
            .build()
    }

    private fun initBookDetailComponent(){
        bookDetailComponent = DaggerBookDetailComponent.builder()
            .appComponent(appComponent)
            .build()
    }
}