package com.optimus.devcolibrifinal.di.modules

import androidx.lifecycle.ViewModel
import com.optimus.devcolibrifinal.di.scopes.ViewModelKey
import com.optimus.devcolibrifinal.viewmodels.BookViewModel
import com.optimus.devcolibrifinal.viewmodels.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by Dmitriy Chebotar on 25.05.2020.
 */

@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(BookViewModel::class)
    abstract fun provideBookViewModel(bookViewModel: BookViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(DetailViewModel::class)
    abstract fun provideDetailViewModel(detailViewModel: DetailViewModel): ViewModel
}