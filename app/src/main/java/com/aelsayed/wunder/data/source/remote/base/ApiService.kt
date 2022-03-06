package com.aelsayed.wunder.data.source.remote.base

import com.aelsayed.wunder.data.models.carDetailsModel.CarDetailsResponse
import com.aelsayed.wunder.data.models.carsModel.CarsResponse
import com.aelsayed.wunder.data.models.rentModel.RentResponse
import com.google.gson.JsonObject
import retrofit2.http.*

interface ApiService {


    @POST
    suspend fun quickRental(
        @Header("Authorization") authorization: String,
        @Url url: String,
        @Body jsonBody: JsonObject
    ): RentResponse

    @GET("cars.json")
    suspend fun fetchCars(): CarsResponse


    @GET("cars/{id}")
    suspend fun carDetails(@Path("id") id: String): CarDetailsResponse


}