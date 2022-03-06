package com.aelsayed.wunder.data.source.remote

import com.aelsayed.wunder.data.models.carDetailsModel.CarDetailsResponse
import com.aelsayed.wunder.data.models.carsModel.CarsResponse
import com.aelsayed.wunder.data.models.rentModel.RentResponse
import com.google.gson.JsonObject


interface CarsRemoteDataSource {

    suspend fun getCars(): CarsResponse

    suspend fun getCarDetails(id: String): CarDetailsResponse

    suspend fun quickRent(
        authorization: String,
        url: String,
        jsonBody: JsonObject
    ): RentResponse
}