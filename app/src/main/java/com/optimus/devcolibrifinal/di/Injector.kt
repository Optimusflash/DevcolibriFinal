package com.optimus.devcolibrifinal.di

import android.content.Context
import com.optimus.devcolibrifinal.di.components.AppComponent
import com.optimus.devcolibrifinal.di.components.DaggerAppComponent

import com.optimus.devcolibrifinal.di.modules.RemoteModule
import com.optimus.devcolibrifinal.di.modules.StorageModule

/**
 * Created by Dmitriy Chebotar on 25.05.2020.
 */
class Injector {
    companion object {
        private lateinit var appComponent: AppComponent

        fun init(applicationContext: Context) {
            appComponent = DaggerAppComponent.builder()
                .remoteModule(RemoteModule())
                .storageModule(StorageModule(applicationContext))
                .build()
        }

        fun getAppComponent() = appComponent
    }
}
