package com.mkitsimple.ktpracticedaggermvvm.di.subcomponents

import com.mkitsimple.ktpracticedaggermvvm.di.modules.MainViewModelModule
import com.mkitsimple.ktpracticedaggermvvm.di.modules.ViewModelFactoryModule
import com.mkitsimple.ktpracticedaggermvvm.di.scopes.MainScope
import com.mkitsimple.ktpracticedaggermvvm.ui.main.MainActivity
import dagger.Subcomponent

@MainScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        MainViewModelModule::class
    ]
)
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}