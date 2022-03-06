package com.aelsayed.wunder.data.repository

import com.aelsayed.wunder.domain.model.carDetailsModel.CarDetailsModel
import com.aelsayed.wunder.domain.model.carsModel.CarsModel
import com.aelsayed.wunder.domain.model.rentModel.RentModel
import com.google.gson.JsonObject

interface ICarsRepository {

    suspend fun getAllCars(): CarsModel

    suspend fun getCarDetails(id: String): CarDetailsModel

    suspend fun rentCar(
        authorization: String,
        url: String,
        jsonBody: JsonObject
    ): RentModel

}