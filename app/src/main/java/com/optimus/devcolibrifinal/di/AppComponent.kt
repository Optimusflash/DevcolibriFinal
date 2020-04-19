package com.optimus.devcolibrifinal.di

import android.app.Activity
import android.app.Application
import com.optimus.devcolibrifinal.activities.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
@Singleton
@Component(modules = [RemoteModule::class])
interface AppComponent {
    //fun inject(app: Application)
    fun inject (activity: MainActivity)
}