package com.optimus.devcolibrifinal.di

import android.app.Application
import android.util.Log
import com.facebook.stetho.Stetho

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("M_App", "app onCreate")
        Stetho.initializeWithDefaults(this)
        initAppComponent()
    }

    private fun initAppComponent() {
        Injector.init(this)
    }



}