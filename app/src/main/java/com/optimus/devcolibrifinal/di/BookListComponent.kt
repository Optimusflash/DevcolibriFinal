package com.optimus.devcolibrifinal.di

import com.optimus.devcolibrifinal.activities.DetailsActivity
import com.optimus.devcolibrifinal.activities.MainActivity
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Dmitriy Chebotar on 25.05.2020.
 */


@Component(dependencies = [AppComponent::class])
@ActivityScope
interface BookListComponent {
    fun inject(mainActivity: MainActivity)
}