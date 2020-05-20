package com.optimus.devcolibrifinal.di

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
class App: Application() {

    companion object{
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        initComponent()

    }

    private fun initComponent() {
        component = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .storageModule(StorageModule(this))
            .build()
    }
}