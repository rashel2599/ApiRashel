package com.example.apirashel.retrofit

import retrofit2.http.GET

interface DogRetrofit {
    @GET("search")
    suspend fun get(): List<DogNetworkEntity>
}