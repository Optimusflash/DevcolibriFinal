package com.optimus.devcolibrifinal.di

import android.app.Activity
import android.app.Application
import com.optimus.devcolibrifinal.activities.MainActivity
import com.optimus.devcolibrifinal.repositories.BookRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Dmitriy Chebotar on 19.04.2020.
 */
@Singleton
@Component(modules = [RemoteModule::class, StorageModule::class])
interface AppComponent {
    fun inject (repository: BookRepository)
}