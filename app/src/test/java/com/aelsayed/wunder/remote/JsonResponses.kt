package com.aelsayed.wunder.remote

val cars = """
[
  {
    "carId": 1,
    "title": "Manfred",
    "lat": 51.5156,
    "lon": 7.4647,
    "licencePlate": "FBL 081",
    "fuelLevel": 27,
    "vehicleStateId": 0,
    "vehicleTypeId": 1,
    "pricingTime": "0,22/km",
    "pricingParking": "0,05/min",
    "reservationState": 0,
    "isClean": false,
    "isDamaged": true,
    "distance": "",
    "address": "Bissenkamp 4",
    "zipCode": "44135",
    "city": "Dortmund",
    "locationId": 2
  },
  {
    "carId": 1,
    "title": "Manfred",
    "lat": 51.5156,
    "lon": 7.4647,
    "licencePlate": "FBL 081",
    "fuelLevel": 27,
    "vehicleStateId": 0,
    "vehicleTypeId": 1,
    "pricingTime": "0,22/km",
    "pricingParking": "0,05/min",
    "reservationState": 0,
    "isClean": false,
    "isDamaged": true,
    "distance": "",
    "address": "Bissenkamp 4",
    "zipCode": "44135",
    "city": "Dortmund",
    "locationId": 2
  }
]
""".trimIndent()


val carDetails = """
    {
        "carId": 19,
        "title": "",
        "isClean": true,
        "isDamaged": false,
        "licencePlate": "KUMPAN",
        "fuelLevel": 27,
        "vehicleStateId": 0,
        "hardwareId": "3A000019B25A0C01",
        "vehicleTypeId": 5,
        "pricingTime": "10ct/min",
        "pricingParking": "",
        "isActivatedByHardware": false,
        "locationId": 2,
        "address": "Münsterstraße 12",
        "zipCode": "44145",
        "city": "Dortmund",
        "lat": 51.5195,
        "lon": 7.465,
        "reservationState": 0,
        "damageDescription": "",
        "vehicleTypeImageUrl": "https://wunderfleet-recruiting-dev.s3.eu-central-1.amazonaws.com/images/vehicle_type_image.png"
    }
""".trimIndent()
val NO_RESULT = """
  {
    "status": "error",
    "message": "No Result"
  }
""".trimIndent()
