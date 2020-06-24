package com.mkitsimple.ktpracticedaggermvvm.data.repositories

import com.mkitsimple.ktpracticedaggermvvm.data.models.PokemonDetails
import com.mkitsimple.ktpracticedaggermvvm.data.models.PokemonResponse
import com.mkitsimple.ktpracticedaggermvvm.data.network.PokemonApi
import com.mkitsimple.ktpracticedaggermvvm.utils.LIMIT
import io.reactivex.Observable

class MyRepository{

    suspend fun performLogin(email: String, password: String): Boolean? {
        if (email == "c1@gmail.com" && password == "123") {
            return true
        }

        return false
    }
}