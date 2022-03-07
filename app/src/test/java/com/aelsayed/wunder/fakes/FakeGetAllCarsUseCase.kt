package com.aelsayed.wunder.fakes

import com.aelsayed.wunder.domain.usecases.MainUseCase
import com.aelsayed.wunder.presentation.model.carsModel.CarsPresentation
import kotlinx.coroutines.flow.Flow
import com.aelsayed.wunder.utils.Result
import com.aelsayed.wunder.utils.Data.cars

class FakeGetAllCarsUseCase(
    result: Result
) : BaseTestUseCase<List<CarsPresentation>, String>(result),
    MainUseCase<String, Flow<List<CarsPresentation>>> {

    override suspend fun invoke(params: String): Flow<List<CarsPresentation>> = execute(params)

    override fun getValue(params: String): List<CarsPresentation> {
        return cars
    }

}