package com.mkitsimple.ktpracticedaggermvvm.di.modules

import androidx.lifecycle.ViewModelProvider
import com.mkitsimple.ktpracticedaggermvvm.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}