package com.example.mvpnyelengi.api

import com.example.mvpnyelengi.data.UserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIInterface {

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserResponse>

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("nama") nama : String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserResponse>

}