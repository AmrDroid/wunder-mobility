package com.aelsayed.wunder.data.models.carsModel

data class CarsItem(
    val address: String,
    val carId: Int,
    val city: String,
    val distance: String,
    val fuelLevel: Int,
    val isClean: Boolean,
    val isDamaged: Boolean,
    val lat: Double,
    val licencePlate: String,
    val locationId: Int,
    val lon: Double,
    val pricingParking: String,
    val pricingTime: String,
    val reservationState: Int,
    val title: String?,
    val vehicleStateId: Int,
    val vehicleTypeId: Int,
    val zipCode: String
)