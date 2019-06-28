package com.tcc.dogapp.mvp.models.network.interfaces

import com.tcc.dogapp.mvp.models.Dog
import com.tcc.dogapp.mvp.models.DogImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DogApiInterface {

    @Headers("Content-Type: application/json", "x-api-key: PUT_YOUR_API_KEY_HERE")
    @GET("/v1/breeds?attach_breed=0")
    fun getDogs(): Call<ArrayList<Dog>>

    @Headers("Content-Type: application/json", "x-api-key: PUT_YOUR_API_KEY_HERE")
    @GET("/v1/images/search")
    fun getRandomDogImage(@Query("breed_id") dogId: String): Call<ArrayList<DogImage>>


}