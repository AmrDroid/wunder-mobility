package com.aelsayed.wunder.domain.usecases


import android.util.Log
import com.aelsayed.wunder.data.repository.ICarsRepository
import com.aelsayed.wunder.domain.base.traceErrorException
import com.aelsayed.wunder.domain.converters.toViewModel
import com.aelsayed.wunder.presentation.model.carsModel.CarsPresentation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllCarsUseCase(
    private val carsRepository: ICarsRepository
) : MainUseCase<String, Flow<List<CarsPresentation>>> {

    override suspend operator fun invoke(params: String) = flow {
            try {
                emit(carsRepository.getAllCars().toViewModel())
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error occurred: ", traceErrorException(e).message.toString())
            }
    }
}