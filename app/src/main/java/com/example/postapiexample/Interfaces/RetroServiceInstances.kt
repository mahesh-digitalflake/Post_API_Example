package com.example.postapiexample.Interfaces

import com.example.postapiexample.DataClasses.User
import com.example.postapiexample.DataClasses.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetroServiceInstances {

    @POST("users")
    @Headers("Accept:application/json","Content-Type:application/json",
    "Authorization:Bearer 6fa5496b806760f6082eb9f44bf531c8a6919c4bc6fc043f0c725daf14c9cc92")
    fun createUser(@Body params: User):Call<UserResponse>
}