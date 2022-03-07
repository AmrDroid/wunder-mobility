package com.aelsayed.wunder.viewmodels

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aelsayed.wunder.fakes.FakeGetAllCarsUseCase
import com.aelsayed.wunder.presentation.model.ViewState
import com.aelsayed.wunder.presentation.viewmodel.CarsViewModel
import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import com.aelsayed.wunder.utils.Result
import com.aelsayed.wunder.utils.Data.cars
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class CarsViewModelTest : BaseViewModelTest() {

    private lateinit var carsViewModel: CarsViewModel

    override fun prepareViewModel(result: Result) {

        val fakeGetAllCarsUseCase = FakeGetAllCarsUseCase(result)
        carsViewModel = CarsViewModel(
            fakeGetAllCarsUseCase, coroutineTestRule.dispatcher
        )
    }

    @Test
    fun get_all_cars_success_state() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)
            carsViewModel.fetchCars()
            Truth.assertThat(carsViewModel.cars.value)
                .isEqualTo(ViewState.success(cars))
        }
    }

}