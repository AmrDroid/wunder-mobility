package com.aelsayed.wunder.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aelsayed.wunder.domain.usecases.MainUseCase
import com.aelsayed.wunder.presentation.model.ViewState
import com.aelsayed.wunder.presentation.model.carDetailsModel.CarDetails
import com.aelsayed.wunder.presentation.model.rentModel.Rent
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CarDetailViewModel constructor(
    private val getCarDetailUseCase: MainUseCase<String, Flow<CarDetails>>,
    private val rentCarUseCase: MainUseCase<Pair<List<String>, JsonObject>, Flow<Rent>>,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    private val _carsDetail: MutableStateFlow<ViewState<CarDetails>> =
        MutableStateFlow(ViewState.loading(null))

    val carsDetail: StateFlow<ViewState<CarDetails>> = _carsDetail


    private val _carsRent: MutableStateFlow<ViewState<Rent>> =
        MutableStateFlow(ViewState.loading(null))

    val carsRent: StateFlow<ViewState<Rent>> = _carsRent


    fun carDetails(
        id: String
    ) {
        viewModelScope.launch(defaultDispatcher)
        {
            _carsDetail.emit(ViewState.loading(data = null))
            try {
                getCarDetailUseCase.invoke(id).collect {
                    _carsDetail.emit(
                        ViewState.success(
                            data = it
                        )
                    )
                }
            } catch (exception: Exception) {
                _carsDetail.emit(
                    ViewState.error(
                        data = null,
                        message = exception.message ?: "Something went wrong.!"
                    )
                )
            }
        }
    }

    fun quickRental(
        authorization: String,
        url: String,
        jsonBody: JsonObject
    ) {
        viewModelScope.launch(defaultDispatcher)
        {
            _carsRent.emit(ViewState.loading(data = null))
            try {
                val param1 = ArrayList<String>()
                param1.add(authorization)
                param1.add(url)
                val pair = Pair<List<String>, JsonObject>(param1, jsonBody)

                rentCarUseCase.invoke(pair).collect {
                    _carsRent.emit(
                        ViewState.success(
                            data = it
                        )
                    )
                }
            } catch (exception: Exception) {
                _carsRent.emit(
                    ViewState.error(
                        data = null,
                        message = exception.message ?: "Something went wrong.!"
                    )
                )
            }
        }
    }


}