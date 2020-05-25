package com.optimus.devcolibrifinal.di

import com.optimus.devcolibrifinal.activities.DetailsActivity
import dagger.Component

/**
 * Created by Dmitriy Chebotar on 25.05.2020.
 */

@Component(dependencies = [AppComponent::class])
@ActivityScope
interface BookDetailComponent {
    fun inject(detailsActivity: DetailsActivity)
}