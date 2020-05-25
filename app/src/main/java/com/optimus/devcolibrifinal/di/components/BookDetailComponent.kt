package com.optimus.devcolibrifinal.di.components

import com.optimus.devcolibrifinal.activities.DetailsActivity
import com.optimus.devcolibrifinal.di.components.AppComponent
import com.optimus.devcolibrifinal.di.modules.RemoteModule
import com.optimus.devcolibrifinal.di.modules.StorageModule
import com.optimus.devcolibrifinal.di.scopes.ActivityScope
import dagger.Component
import dagger.Subcomponent

/**
 * Created by Dmitriy Chebotar on 25.05.2020.
 */

@Subcomponent
@ActivityScope
interface BookDetailComponent {
    fun inject(detailsActivity: DetailsActivity)
}