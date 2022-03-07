package com.aelsayed.wunder.remote.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aelsayed.wunder.data.repository.CarsRepositoryImp
import com.aelsayed.wunder.data.repository.ICarsRepository
import com.aelsayed.wunder.data.source.remote.CarsRemoteDataSource
import com.aelsayed.wunder.data.source.remote.CarsRemoteDataSourceImp
import com.aelsayed.wunder.remote.BaseClient
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class RestaurantsRepositoryClient : BaseClient() {

    private lateinit var restaurantsRepo: ICarsRepository
    private lateinit var remoteDataSource: CarsRemoteDataSource

    @Before
    override fun setup() {
        super.setup()
        remoteDataSource = CarsRemoteDataSourceImp(apiService)
        restaurantsRepo = CarsRepositoryImp(remoteDataSource)

    }

    @Test
    fun get_cars_test() {
        runBlocking {
            val rests = restaurantsRepo.getAllCars()
            Truth.assertThat(rests).isNotNull()
        }
    }


    @Test
    fun get_car_details_test() {
        runBlocking {
            val rests = restaurantsRepo.getCarDetails("1")
            Truth.assertThat(rests).isNotNull()
        }
    }
}
