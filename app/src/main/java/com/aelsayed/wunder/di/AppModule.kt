package com.aelsayed.wunder.di

import com.aelsayed.wunder.data.repository.CarsRepositoryImp
import com.aelsayed.wunder.data.repository.ICarsRepository
import com.aelsayed.wunder.data.source.remote.CarsRemoteDataSource
import com.aelsayed.wunder.data.source.remote.CarsRemoteDataSourceImp
import com.aelsayed.wunder.data.source.remote.base.ApiService
import org.koin.dsl.module


val appModule = module {

    single { createRemoteDataSource(get()) }
    single<ICarsRepository> { CarsRepositoryImp(get()) }

}

fun createRemoteDataSource(apiService: ApiService): CarsRemoteDataSource {
    return CarsRemoteDataSourceImp(apiService)
}
