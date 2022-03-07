package com.aelsayed.wunder.fakes

import com.aelsayed.wunder.domain.usecases.MainUseCase
import com.aelsayed.wunder.presentation.model.carDetailsModel.CarDetails
import com.aelsayed.wunder.utils.Data.carDetail
import kotlinx.coroutines.flow.Flow
import com.aelsayed.wunder.utils.Result


class FakeGetCarDetailsUseCase(
    result: Result
) : BaseTestUseCase<CarDetails, String>(result),
    MainUseCase<String, Flow<CarDetails>> {

    override suspend fun invoke(params: String): Flow<CarDetails> = execute(params)

    override fun getValue(params: String): CarDetails {
        return carDetail
    }
}