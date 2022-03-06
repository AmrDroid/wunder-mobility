package com.aelsayed.wunder.data.source.remote

import com.aelsayed.wunder.data.models.carDetailsModel.CarDetailsResponse
import com.aelsayed.wunder.data.models.carsModel.CarsResponse
import com.aelsayed.wunder.data.models.rentModel.RentResponse
import com.aelsayed.wunder.data.source.remote.base.ApiService
import com.google.gson.JsonObject

class CarsRemoteDataSourceImp(private val apiService: ApiService) : CarsRemoteDataSource {

    override suspend fun getCars(): CarsResponse = apiService.fetchCars()

    override suspend fun getCarDetails(id: String): CarDetailsResponse = apiService.carDetails(id)

    override suspend fun quickRent(
        authorization: String,
        url: String,
        jsonBody: JsonObject
    ): RentResponse = apiService.quickRental(authorization, url, jsonBody)

}