package com.mkitsimple.ktpracticedaggermvvm.di.modules

import androidx.lifecycle.ViewModel
import com.mkitsimple.ktpracticedaggermvvm.ui.main.MainViewModel
import com.mkitsimple.ktpracticedaggermvvm.viewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindPokemonListViewModel(viewModel: MainViewModel): ViewModel
}