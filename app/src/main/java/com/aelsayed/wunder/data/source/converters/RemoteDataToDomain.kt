package com.aelsayed.wunder.data.source.converters

import com.aelsayed.wunder.data.models.carDetailsModel.CarDetailsResponse
import com.aelsayed.wunder.data.models.carsModel.CarsItem
import com.aelsayed.wunder.data.models.carsModel.CarsResponse
import com.aelsayed.wunder.data.models.rentModel.RentResponse
import com.aelsayed.wunder.domain.model.carDetailsModel.CarDetailsModel
import com.aelsayed.wunder.domain.model.carsModel.CarsModel
import com.aelsayed.wunder.domain.model.carsModel.CarsModelItem
import com.aelsayed.wunder.domain.model.rentModel.RentModel

//from remote data layer to provide data to domain layer

internal fun CarsResponse.toDomain(): CarsModel {
    val carsModel = CarsModel()
    val list = ArrayList<CarsModelItem>()
    for (item in this)
        list.add(item.toDomain())

    carsModel.addAll(list)
    return carsModel
}

internal fun CarsItem.toDomain() = CarsModelItem(
    address = this.address,
    carId = this.carId,
    city = this.city,
    fuelLevel = this.fuelLevel,
    isClean = this.isClean,
    isDamaged = this.isDamaged,
    lat = this.lat,
    licencePlate = this.licencePlate,
    locationId = this.locationId,
    lon = this.lon,
    pricingParking = this.pricingParking,
    pricingTime = this.pricingTime,
    reservationState = this.reservationState,
    title = this.title ?: "",
    vehicleStateId = this.vehicleStateId,
    vehicleTypeId = this.vehicleTypeId,
    distance = this.distance,
    zipCode = this.zipCode
)

internal fun CarDetailsResponse.toDomain() = CarDetailsModel(
    address = this.address,
    carId = this.carId,
    city = this.city,
    damageDescription = this.damageDescription,
    fuelLevel = this.fuelLevel,
    hardwareId = this.hardwareId,
    isActivatedByHardware = this.isActivatedByHardware,
    isClean = this.isClean,
    isDamaged = this.isDamaged,
    lat = this.lat,
    licencePlate = this.licencePlate,
    locationId = this.locationId,
    lon = this.lon,
    pricingParking = this.pricingParking,
    pricingTime = this.pricingTime,
    reservationState = this.reservationState,
    title = this.title,
    vehicleStateId = this.vehicleStateId,
    vehicleTypeId = this.vehicleTypeId,
    vehicleTypeImageUrl = this.vehicleTypeImageUrl,
    zipCode = this.zipCode
)


internal fun RentResponse.toDomain() = RentModel(
    carId = this.carId,
    damageDescription = this.damageDescription,
    licencePlate = this.licencePlate,
    cost = this.cost,
    drivenDistance = this.drivenDistance,
    endTime = this.endTime,
    fuelCardPin = this.fuelCardPin,
    isParkModeEnabled = this.isParkModeEnabled,
    reservationId = this.reservationId,
    startAddress = this.startAddress,
    startTime = this.startTime,
    userId = this.userId
)