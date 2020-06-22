package com.mkitsimple.ktpracticedaggermvvm.data.repositories

class MyRepository {

    suspend fun performLogin(email: String, password: String): Boolean? {
        if (email == "c1@gmail.com" && password == "123") {
            return true
        }

        return false
    }
}