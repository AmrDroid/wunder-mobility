package com.aelsayed.wunder.utils

import com.aelsayed.wunder.presentation.model.carDetailsModel.CarDetails
import com.aelsayed.wunder.presentation.model.carsModel.CarsPresentation
import com.aelsayed.wunder.presentation.model.rentModel.Rent


object Data {

    val cars = arrayListOf(
        CarsPresentation(
            carId = 1,
            title = "Manfred",
            lat = 51.5156,
            lon = 7.4647,
            licencePlate = "FBL 081",
            fuelLevel = 27,
            vehicleStateId = 0,
            vehicleTypeId = 1,
            pricingTime = "0,22/km",
            pricingParking = "0,05/min",
            reservationState = 0,
            isClean = false,
            isDamaged = true,
            distance = "",
            address = "Bissenkamp 4",
            zipCode = "44135",
            city = "Dortmund",
            locationId = 2
        ),
        CarsPresentation(
            carId = 1,
            title = "Manfred",
            lat = 51.5156,
            lon = 7.4647,
            licencePlate = "FBL 081",
            fuelLevel = 27,
            vehicleStateId = 0,
            vehicleTypeId = 1,
            pricingTime = "0,22/km",
            pricingParking = "0,05/min",
            reservationState = 0,
            isClean = false,
            isDamaged = true,
            distance = "",
            address = "Bissenkamp 4",
            zipCode = "44135",
            city = "Dortmund",
            locationId = 2
        )
    )


    val carDetail = CarDetails(
        carId = 1,
        title = "Manfred",
        lat = 51.5156,
        lon = 7.4647,
        licencePlate = "FBL 081",
        fuelLevel = 27,
        vehicleStateId = 0,
        vehicleTypeId = 1,
        pricingTime = "0,22/km",
        pricingParking = "0,05/min",
        reservationState = 0,
        isClean = false,
        isDamaged = true,
        address = "Bissenkamp 4",
        zipCode = "44135",
        city = "Dortmund",
        locationId = 2,
        damageDescription = "",
        hardwareId = "",
        isActivatedByHardware = true,
        vehicleTypeImageUrl = ""
    )
    val rent = Rent(
        carId = 1,
        cost = 1,
        damageDescription = "",
        drivenDistance = 1,
        endTime = 1,
        fuelCardPin = "",
        isParkModeEnabled = false,
        licencePlate = "",
        reservationId = 1,
        startAddress = "",
        startTime = 1,
        userId = 1
    )
}
