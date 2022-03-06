package com.aelsayed.wunder.di

import com.aelsayed.wunder.data.repository.ICarsRepository
import com.aelsayed.wunder.domain.usecases.*
import com.aelsayed.wunder.presentation.model.carDetailsModel.CarDetails
import com.aelsayed.wunder.presentation.model.carsModel.CarsPresentation
import com.aelsayed.wunder.presentation.model.rentModel.Rent
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.module
import org.koin.core.qualifier.named

val useCasesModule = module {

    single(named(PARAMS.GET_ALL_CARS)) { provideGetCarsUseCase(get()) }

    single(named(PARAMS.GET_CAR_DETAILS)) { provideGetCarDetailUseCase(get()) }

    single(named(PARAMS.RENT_CAR)) { provideRentCarUseCase(get()) }
}

fun provideGetCarsUseCase(
    carsRepository: ICarsRepository
): MainUseCase<String, Flow<List<CarsPresentation>>> {
    return GetAllCarsUseCase(carsRepository)
}


fun provideGetCarDetailUseCase(
    carsRepository: ICarsRepository
): MainUseCase<String, Flow<CarDetails>> {
    return GetCarDetailUseCase(carsRepository)
}


fun provideRentCarUseCase(
    carsRepository: ICarsRepository
): MainUseCase<Pair<List<String>, JsonObject>, Flow<Rent>> {
    return RentCarUseCase(carsRepository)
}

object PARAMS {
    const val GET_ALL_CARS = "FETCH_CARS"
    const val GET_CAR_DETAILS = "FETCH_CARS_DETAILS"
    const val RENT_CAR = "RENT_CAR"
}