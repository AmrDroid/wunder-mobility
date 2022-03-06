package com.aelsayed.wunder.presentation.util

import android.content.Context

class LocationCache constructor(mContext: Context) {
    private val locationCacheLat = "locationCache"
    private val locationCacheLng = "locationCache"
    private val context = mContext


    fun getLat(): String {
        val sharedPreferences = context.getSharedPreferences(
            locationCacheLat, 0
        )
        return sharedPreferences.getString("lat", "").toString()
    }

    fun setLat(lat: String) {
        val sharedPreferences = context.getSharedPreferences(
            locationCacheLat,
            0
        )
        val editor = sharedPreferences.edit()
        editor.putString("lat", lat)
        editor.apply()
    }

    fun getLng(): String {
        val sharedPreferences = context.getSharedPreferences(
            locationCacheLng, 0
        )
        return sharedPreferences.getString("lng", "").toString()
    }

    fun setLng(lat: String) {
        val sharedPreferences = context.getSharedPreferences(
            locationCacheLng,
            0
        )
        val editor = sharedPreferences.edit()
        editor.putString("lng", lat)
        editor.apply()
    }


}