package com.mkitsimple.ktpracticedaggermvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkitsimple.ktpracticedaggermvvm.data.repositories.MyRepository
import com.mkitsimple.ktpracticedaggermvvm.utils.Coroutines
import kotlinx.coroutines.Job
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MyRepository) : ViewModel() {

//    @Inject
//    lateinit var repository: MyRepository
//    init {
//        this.repository  = MyRepository()
//    }

    private lateinit var job: Job

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess: LiveData<Boolean>
        get() = _isLoginSuccess

    fun performLogin(email: String, password: String) {
            job = Coroutines.ioThenMain(
                { repository.performLogin(email, password) },
                { _isLoginSuccess.value = it }
                //_isLoginSuccess.value = repository.performLogin(email, password)
            )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}