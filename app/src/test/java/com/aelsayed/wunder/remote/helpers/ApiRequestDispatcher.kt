package com.aelsayed.wunder.remote.helpers

import com.aelsayed.wunder.remote.ApiConstants.NO_RES_URI
import com.aelsayed.wunder.remote.ApiConstants.URI_CARS
import com.aelsayed.wunder.remote.ApiConstants.URI_CAR_DETAIL
import com.aelsayed.wunder.remote.NO_RESULT
import com.aelsayed.wunder.remote.carDetails
import com.aelsayed.wunder.remote.cars
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection


internal class ApiRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {

        return when (request.path) {

            URI_CARS -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(cars)
            }

            URI_CAR_DETAIL -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(carDetails)
            }


            NO_RES_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(NO_RESULT)
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }

}