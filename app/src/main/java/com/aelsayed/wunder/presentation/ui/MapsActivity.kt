package com.aelsayed.wunder.presentation.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.aelsayed.wunder.databinding.ActivityMapsBinding
import com.aelsayed.wunder.presentation.util.LocationCache
import com.aelsayed.wunder.presentation.viewmodel.CarsViewModel
import com.aelsayed.wunder.R
import com.aelsayed.wunder.presentation.model.Status
import com.aelsayed.wunder.presentation.util.InfoWindowAdapter
import com.aelsayed.wunder.presentation.util.distance
import kotlinx.coroutines.flow.collect

class MapsActivity : BaseActivity<ActivityMapsBinding>(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    private lateinit var map: GoogleMap
    private val requestLocationPermission = 1
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private val carsViewModel: CarsViewModel by viewModel()
    private var firstMarkerClick = true
    private var firstLocationUpdate = true
    private var carId = ""
    private var myMarker: Marker? = null

    override fun setUpViews() {
        initUi()
    }

    override fun getViewBinding() = ActivityMapsBinding.inflate(layoutInflater)

    private fun initUi() {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        getLocationUpdates()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMarkerClickListener(this)

        enableMyLocation()
        if (firstMarkerClick) {

            map.setOnMarkerClickListener { marker ->
                val lat = marker.position.latitude
                val lng = marker.position.longitude
                val title = marker.title
                carId = marker.snippet.toString()
                map.clear()

                myMarker = map.addMarker(
                    MarkerOptions().position(
                        LatLng(lat, lng)
                    )
                        .title(title)
                        .snippet(carId)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.car))

                )
                firstMarkerClick = false
                map.setInfoWindowAdapter(InfoWindowAdapter(this))
                myMarker?.showInfoWindow()
                false

            }
        }

        map.setOnInfoWindowClickListener {
            val intent = Intent(this, CarDetailsActivity::class.java)
            intent.putExtra("carId", carId)
            startActivity(intent)
        }

    }

    private fun getCars() {
        lifecycleScope.launchWhenStarted {
            carsViewModel.cars.collect {
                when (it.status) {
                    Status.LOADING -> {
                        binding.loading.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.loading.visibility = View.GONE
                        if (it.data != null) {
                            for (i in it.data) {
                                if (i.title.isNotEmpty()) {
                                    map.addMarker(
                                        MarkerOptions().position(LatLng(i.lat, i.lon))
                                            .title(i.title)
                                            .snippet(i.carId.toString())
                                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.car))
                                    )
                                } else {
                                    map.addMarker(
                                        MarkerOptions().position(LatLng(i.lat, i.lon))
                                            .title(getString(R.string.no_title))
                                            .snippet(i.carId.toString())
                                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.car))
                                    )
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.loading.visibility = View.GONE
                        Toast.makeText(
                            this@MapsActivity,
                           it.message.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

            }
        }

    }

    // Checks that users have given permission
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    // Checks if users have given their location and sets location enabled if so.
    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                requestLocationPermission
            )
        }
    }

    // Callback for the result from requesting permissions.
    // This method is invoked for every call on requestPermissions(android.app.Activity, String[],
    // int).
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Check if location permissions are granted and if so enable the
        // location data layer.
        if (requestCode == requestLocationPermission) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }


    //onLocationResult call when location is changed
    private fun getLocationUpdates() {
        val locationCache = LocationCache(applicationContext)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        locationRequest = LocationRequest.create().apply {
            interval = 100
            fastestInterval = 50
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            maxWaitTime = 100
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                if (locationResult.locations.isNotEmpty()) {
                    // get latest location
                    if (firstMarkerClick) {

                        val location =
                            locationResult.lastLocation
                        val lat = location.latitude
                        val lng = location.longitude

                        if (firstLocationUpdate) {
                            locationCache.setLat(lat.toString())
                            locationCache.setLng(lng.toString())
                            updateMap(lat, lng)

                            firstLocationUpdate = false
                        }
                        if (distance(
                                locationCache.getLat().toDouble(),
                                locationCache.getLng().toDouble(),
                                lat,
                                lng
                            ) > .5
                        ) {
                            locationCache.setLat(lat.toString())
                            locationCache.setLng(lng.toString())
                            updateMap(lat, lng)

                        }
                    }


                }


            }
        }
    }

    //start location updates
    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        Looper.myLooper()?.let {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                it
            )
        }
    }

    // stop location updates
    private fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    // stop receiving location update when activity not visible/foreground
    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }

    // start receiving location update when activity  visible/foreground
    override fun onResume() {
        super.onResume()
        carsViewModel.fetchCars()
        getCars()
        firstMarkerClick = true
        startLocationUpdates()

    }

    override fun onMarkerClick(p0: Marker): Boolean {
        return false
    }

    private fun updateMap(lat: Double, lng: Double) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    lat,
                    lng
                ), 17.0f
            )
        )

    }


}