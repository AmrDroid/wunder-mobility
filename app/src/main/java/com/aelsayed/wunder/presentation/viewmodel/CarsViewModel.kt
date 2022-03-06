package com.aelsayed.wunder.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aelsayed.wunder.domain.usecases.MainUseCase
import com.aelsayed.wunder.presentation.model.ViewState
import com.aelsayed.wunder.presentation.model.carsModel.CarsPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CarsViewModel constructor(
    private val getAllCarsUseCase: MainUseCase<String, Flow<List<CarsPresentation>>>,
) : ViewModel() {

    private val _cars: MutableStateFlow<ViewState<List<CarsPresentation>>> =
        MutableStateFlow(ViewState.loading(null))

    val cars: StateFlow<ViewState<List<CarsPresentation>>> = _cars

    fun fetchCars() {
        viewModelScope.launch(Dispatchers.IO)
        {
            _cars.emit(ViewState.loading(data = null))
            try {
                getAllCarsUseCase.invoke("").collect {
                        _cars.emit(
                            ViewState.success(
                                data = it
                            )
                        )
                }
            } catch (exception: Exception) {
                _cars.emit(
                    ViewState.error(
                        data = null,
                        message = exception.message ?: "Something went wrong.!"
                    )
                )
            }
        }
    }
}