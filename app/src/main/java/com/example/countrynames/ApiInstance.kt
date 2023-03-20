package com.example.countrynames

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    const val BASE_URL = "https://countriesnow.space/api/v0.1/"
    fun getInstance(): ApiCall {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiCall::class.java)
    }
}