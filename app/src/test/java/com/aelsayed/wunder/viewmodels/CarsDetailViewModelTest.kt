package com.aelsayed.wunder.viewmodels

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aelsayed.wunder.fakes.FakeGetCarDetailsUseCase
import com.aelsayed.wunder.fakes.FakeRentCarUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.runner.RunWith
import com.aelsayed.wunder.utils.Result
import com.aelsayed.wunder.presentation.model.ViewState
import com.aelsayed.wunder.presentation.viewmodel.CarDetailViewModel
import com.aelsayed.wunder.utils.Data
import com.google.gson.JsonObject
import kotlinx.coroutines.test.runBlockingTest

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class CarsDetailViewModelTest : BaseViewModelTest() {

    private lateinit var carsViewModel: CarDetailViewModel

    override fun prepareViewModel(result: Result) {

        val fakeRentCarUseCase = FakeRentCarUseCase(result)
        val getCarDetailsUseCase = FakeGetCarDetailsUseCase(result)


        carsViewModel = CarDetailViewModel(
            getCarDetailsUseCase, fakeRentCarUseCase, coroutineTestRule.dispatcher
        )

    }

    @Test
    fun get_car_detail_success_state() {
        coroutineTestRule.dispatcher.runBlockingTest {
            prepareViewModel(Result.SUCCESS)
            carsViewModel.carDetails("1")
            Truth.assertThat(carsViewModel.carsDetail.value)
                .isEqualTo(ViewState.success(Data.carDetail))
        }
    }

    @Test
    fun rent_car_success_state() {
        coroutineTestRule.dispatcher.runBlockingTest  {
            prepareViewModel(Result.SUCCESS)
            carsViewModel.quickRental("1", "", JsonObject())
            Truth.assertThat(carsViewModel.carsRent.value)
                .isEqualTo(ViewState.success(Data.rent))
        }
    }
}