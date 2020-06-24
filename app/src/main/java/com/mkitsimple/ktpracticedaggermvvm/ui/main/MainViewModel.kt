package com.mkitsimple.ktpracticedaggermvvm.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkitsimple.ktpracticedaggermvvm.data.models.PokemonResponse
import com.mkitsimple.ktpracticedaggermvvm.data.repositories.MyRepository
import com.mkitsimple.ktpracticedaggermvvm.data.repositories.PokemonRepository
import com.mkitsimple.ktpracticedaggermvvm.domain.AppUsecase
import com.mkitsimple.ktpracticedaggermvvm.domain.PokemonUsecase
import com.mkitsimple.ktpracticedaggermvvm.utils.Coroutines
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Job
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

//    @Inject
//    lateinit var repository: MyRepository
//    init {
//        this.repository  = MyRepository()
//    }
    @Inject
    lateinit var usecase: PokemonUsecase

    private lateinit var job: Job

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess: LiveData<Boolean>
        get() = _isLoginSuccess

    fun performLogin(email: String, password: String) {
            job = Coroutines.ioThenMain(
                { usecase.performLogin(email, password) },
                { _isLoginSuccess.value = it }
                //_isLoginSuccess.value = repository.performLogin(email, password)
            )
    }

    private val pokemonListMutableLiveData = MutableLiveData<PokemonResponse>()

    fun getPokemonList() {
        //Log.d("PokemonCalled", "PokemonCalled")
        if (pokemonListMutableLiveData.value != null) {
            return
        }
        val disposable = usecase.getPokemonList(0)
            .subscribe {
                pokemonListMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonList() = pokemonListMutableLiveData

    val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
        compositeDisposable.clear()
    }
}