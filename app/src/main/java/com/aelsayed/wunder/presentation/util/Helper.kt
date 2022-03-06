package com.aelsayed.wunder.presentation.util

import android.content.Context
import android.widget.ImageView
import com.aelsayed.wunder.R
import com.bumptech.glide.Glide
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

fun loadImageWithPicasso(url: String?, context: Context, imageView: ImageView) {
    if (url != "") {
        Glide.with(context).load(url).error(R.drawable.default_image)
            .into(imageView)
    } else {
        Glide.with(context).load(R.drawable.default_image).error(R.drawable.default_image)
            .into(imageView)
    }
}

fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val theta = lon1 - lon2
    var dist = (sin(deg2rad(lat1))
            * sin(deg2rad(lat2))
            + (cos(deg2rad(lat1))
            * cos(deg2rad(lat2))
            * cos(deg2rad(theta))))
    dist = acos(dist)
    dist = rad2deg(dist)
    dist *= 60 * 1.1515
    return dist
}

private fun deg2rad(deg: Double): Double {
    return deg * Math.PI / 180.0
}

private fun rad2deg(rad: Double): Double {
    return rad * 180.0 / Math.PI
}