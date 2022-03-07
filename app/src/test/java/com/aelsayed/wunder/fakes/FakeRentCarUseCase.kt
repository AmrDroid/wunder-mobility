package com.aelsayed.wunder.fakes

import com.aelsayed.wunder.domain.usecases.MainUseCase
import com.aelsayed.wunder.utils.Data.rent
import com.aelsayed.wunder.presentation.model.rentModel.Rent
import kotlinx.coroutines.flow.Flow
import com.aelsayed.wunder.utils.Result
import com.google.gson.JsonObject


class FakeRentCarUseCase(
    result: Result
) : BaseTestUseCase<Rent, Pair<List<String>, JsonObject>>(result),
    MainUseCase<Pair<List<String>, JsonObject>, Flow<Rent>> {

    override suspend fun invoke(params: Pair<List<String>, JsonObject>): Flow<Rent> = execute(params)

    override fun getValue(params: Pair<List<String>, JsonObject>): Rent {
        return rent
    }
}