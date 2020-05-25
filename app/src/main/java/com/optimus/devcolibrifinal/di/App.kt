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

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        initAppComponent()
    }

    private fun initAppComponent() {
        Injector.init(this)
    }



}