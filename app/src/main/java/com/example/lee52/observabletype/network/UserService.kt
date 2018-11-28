package com.example.lee52.observabletype.network

import com.example.lee52.observabletype.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun getUsers(): Observable<List<User>>

}