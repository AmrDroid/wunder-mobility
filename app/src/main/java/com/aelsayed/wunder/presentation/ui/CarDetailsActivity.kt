package com.aelsayed.wunder.presentation.ui

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.aelsayed.wunder.BuildConfig.*
import com.aelsayed.wunder.R
import com.aelsayed.wunder.databinding.ActivityCarDetailsBinding
import com.aelsayed.wunder.presentation.model.Status
import com.aelsayed.wunder.presentation.util.loadImageWithPicasso
import com.aelsayed.wunder.presentation.viewmodel.CarDetailViewModel
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception


class CarDetailsActivity : BaseActivity<ActivityCarDetailsBinding>() {
    private var carId = ""
    private val carDetailsViewModel: CarDetailViewModel by viewModel()

    override fun setUpViews() {
        initUi()
        initEventDriven()
    }

    private fun initEventDriven() {
        binding.tvRent.setOnClickListener {

            carDetailsViewModel.quickRental(
                "Bearer $TOKEN",
                QUICK_RENTAL, createRequestBody(carId)
            )
            getQuickRental()

        }
    }

    private fun getQuickRental() {
        lifecycleScope.launchWhenStarted {
            carDetailsViewModel.carsRent.collect {
                when (it.status) {
                    Status.LOADING -> {
                        Log.e("QuickRentalLOADING", it.message.toString())
                        binding.loading.visibility = View.VISIBLE
                    }

                    Status.SUCCESS -> {
                        binding.loading.visibility = View.GONE
                        Toast.makeText(
                            this@CarDetailsActivity,
                            getString(R.string.rentedSuccessfully),
                            Toast.LENGTH_LONG
                        ).show()
                        finish()
                    }
                    Status.ERROR -> {
                        binding.loading.visibility = View.GONE
                        Toast.makeText(
                            this@CarDetailsActivity,
                            it.message.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                        Log.e("QuickRentalError", it.message.toString())
                    }
                }

            }
        }


    }

    override fun getViewBinding() = ActivityCarDetailsBinding.inflate(layoutInflater)

    private fun initUi() {
        carId = intent.getStringExtra("carId").toString()
        Log.e("carId1", carId)
        carDetailsViewModel.carDetails(carId)
        getCarDetails()
    }

    private fun getCarDetails() {
        lifecycleScope.launchWhenStarted {
            carDetailsViewModel.carsDetail.collect {
                when (it.status) {
                    Status.LOADING -> {
                        Log.e("CarDetailsLOADING", it.message.toString())
                        binding.loading.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.loading.visibility = View.GONE

                        loadImageWithPicasso(
                            it.data?.vehicleTypeImageUrl,
                            this@CarDetailsActivity,
                            binding.ivCarImage
                        )
                        binding.tvTitle.text = it.data?.title
                        binding.tvIsClean.text = it.data?.isClean.toString()
                        binding.tvIsDamaged.text = it.data?.isDamaged.toString()
                        binding.tvLicencePlate.text = it.data?.licencePlate
                        binding.tvFuelLevel.text = it.data?.fuelLevel.toString()
                        binding.tvPricingTime.text = it.data?.pricingTime
                        binding.tvPricingParking.text = it.data?.pricingParking
                        binding.tvAddress.text = it.data?.address
                        binding.tvZipCode.text = it.data?.zipCode
                        binding.tvCity.text = it.data?.city
                        binding.tvLat.text = it.data?.lat.toString()
                        binding.tvLon.text = it.data?.lon.toString()
                        binding.tvDamageDescription.text = it.data?.damageDescription

                    }
                    Status.ERROR -> {
                        binding.loading.visibility = View.GONE
                        Toast.makeText(
                            this@CarDetailsActivity,
                            it.message.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                        Log.e("CarDetailsError", it.message.toString())
                    }
                }

            }
        }

    }

    private fun createRequestBody(id: String): JsonObject {
        val gsonObject = JsonObject()
        try {
//            val jsonObj_ = JSONObject()
//            jsonObj_.put("carId", id)
//            val jsonParser = JsonParser()
//            gsonObject = jsonParser.parse(jsonObj_.toString()) as JsonObject

            gsonObject.addProperty("carId", id)


            //print parameter
            Log.e("gsonObject", "AS PARAMETER  $gsonObject")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Exception", e.toString())

        }

        return gsonObject
    }
}
