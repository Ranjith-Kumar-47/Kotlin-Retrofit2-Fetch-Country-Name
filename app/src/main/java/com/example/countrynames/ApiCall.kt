package com.example.countrynames

import retrofit2.Call
import retrofit2.http.GET

interface ApiCall {
    @GET("countries")  //BASE URL = https://countriesnow.space/api/v0.1/
    fun getCountryList(): Call<CountryNameModelClass>
}