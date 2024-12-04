package com.example.parciale3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class FarmaciaDetailActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmacia_detail)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as com.google.android.gms.maps.SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val lat = intent.getDoubleExtra("lat", 0.0)
        val lng = intent.getDoubleExtra("lng", 0.0)
        val nombre = intent.getStringExtra("nombre")

        if (lat != 0.0 && lng != 0.0) {
            val location = LatLng(lat, lng)
            map.addMarker(MarkerOptions().position(location).title(nombre))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        } else {
            // Manejo de error para coordenadas no válidas
            // Ejemplo: Toast o Log
        }
    }
}
