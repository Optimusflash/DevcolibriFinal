package com.optimus.devcolibrifinal.di

import android.app.Application

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
class App: Application() {

    companion object{
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initComponent()

    }

    private fun initComponent() {
        component = DaggerAppComponent.create()
    }
}