package com.aelsayed.wunder.di

import com.aelsayed.wunder.presentation.viewmodel.CarDetailViewModel
import com.aelsayed.wunder.presentation.viewmodel.CarsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        CarsViewModel(
            get(named(PARAMS.GET_ALL_CARS))
        )
    }

    viewModel {
        CarDetailViewModel(
            get(named(PARAMS.GET_CAR_DETAILS)),
            get(named(PARAMS.RENT_CAR))
        )
    }
}