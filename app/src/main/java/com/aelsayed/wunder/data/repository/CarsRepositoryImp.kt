package com.aelsayed.wunder.data.repository

import com.aelsayed.wunder.data.source.converters.toDomain
import com.aelsayed.wunder.data.source.remote.CarsRemoteDataSource
import com.aelsayed.wunder.domain.model.carDetailsModel.CarDetailsModel
import com.aelsayed.wunder.domain.model.carsModel.CarsModel
import com.aelsayed.wunder.domain.model.rentModel.RentModel
import com.google.gson.JsonObject

/**
 * This class is responsible to choose a source for fetching data
 * Remote data using [CarsRemoteDataSource]
 * */
class CarsRepositoryImp constructor(
    private val carsRemoteDataSource: CarsRemoteDataSource
) : ICarsRepository {


    override suspend fun getAllCars(): CarsModel {
        return carsRemoteDataSource.getCars().toDomain()
    }

    override suspend fun getCarDetails(id: String): CarDetailsModel {
        return carsRemoteDataSource.getCarDetails(id).toDomain()
    }

    override suspend fun rentCar(
        authorization: String,
        url: String,
        jsonBody: JsonObject
    ): RentModel {
        return carsRemoteDataSource.quickRent(authorization, url, jsonBody).toDomain()
    }


}