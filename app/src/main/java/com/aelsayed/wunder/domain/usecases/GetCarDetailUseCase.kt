package com.aelsayed.wunder.domain.usecases


import android.util.Log
import com.aelsayed.wunder.data.repository.ICarsRepository
import com.aelsayed.wunder.domain.base.traceErrorException
import com.aelsayed.wunder.domain.converters.toViewModel
import com.aelsayed.wunder.presentation.model.carDetailsModel.CarDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCarDetailUseCase(
    private val carsRepository: ICarsRepository
) : MainUseCase<String, Flow<CarDetails>> {

    override suspend operator fun invoke(id: String) = flow {
            try {
                emit(carsRepository.getCarDetails(id).toViewModel())
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error occurred : ", traceErrorException(e).message.toString())
            }
    }
}