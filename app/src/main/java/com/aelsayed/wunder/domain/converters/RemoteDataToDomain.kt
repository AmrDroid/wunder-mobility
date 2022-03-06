package com.aelsayed.wunder.domain.converters


import com.aelsayed.wunder.domain.model.carDetailsModel.CarDetailsModel
import com.aelsayed.wunder.domain.model.carsModel.CarsModel
import com.aelsayed.wunder.domain.model.carsModel.CarsModelItem
import com.aelsayed.wunder.domain.model.rentModel.RentModel
import com.aelsayed.wunder.presentation.model.carDetailsModel.CarDetails
import com.aelsayed.wunder.presentation.model.carsModel.CarsPresentation
import com.aelsayed.wunder.presentation.model.rentModel.Rent

//from remote data layer to provide data to domain layer

internal fun CarsModel.toViewModel(): List<CarsPresentation> {
    val cars = ArrayList<CarsPresentation>()
    for (item in this)
        cars.add(item.toViewModel())
    return cars
}

internal fun CarsModelItem.toViewModel() = CarsPresentation(
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
    title = this.title,
    vehicleStateId = this.vehicleStateId,
    vehicleTypeId = this.vehicleTypeId,
    distance = this.distance,
    zipCode = this.zipCode
)

internal fun CarDetailsModel.toViewModel() = CarDetails(
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


internal fun RentModel.toViewModel() = Rent(
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