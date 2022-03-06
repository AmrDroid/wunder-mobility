package com.aelsayed.wunder.domain.usecases


import android.util.Log
import com.aelsayed.wunder.data.repository.ICarsRepository
import com.aelsayed.wunder.domain.base.traceErrorException
import com.aelsayed.wunder.domain.converters.toViewModel
import com.aelsayed.wunder.presentation.model.rentModel.Rent
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RentCarUseCase(
    private val carsRepository: ICarsRepository
) : MainUseCase<Pair<List<String>, JsonObject>, Flow<Rent>> {

    override suspend operator fun invoke(params: Pair<List<String>, JsonObject>) = flow {
            try {
                emit(carsRepository.rentCar(params.first[0], params.first[1], params.second).toViewModel())
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error occurred: ", traceErrorException(e).message.toString())
            }
    }

}