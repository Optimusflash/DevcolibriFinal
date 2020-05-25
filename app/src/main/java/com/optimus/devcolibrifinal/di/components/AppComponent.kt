package com.optimus.devcolibrifinal.di.components

import com.optimus.devcolibrifinal.activities.DetailsActivity
import com.optimus.devcolibrifinal.activities.MainActivity
import com.optimus.devcolibrifinal.di.modules.RemoteModule
import com.optimus.devcolibrifinal.di.modules.StorageModule
import com.optimus.devcolibrifinal.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
@Singleton
@Component(modules = [RemoteModule::class, StorageModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(detailsActivity: DetailsActivity)
}