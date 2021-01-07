package com.sctce.kotlinapp

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var marker: Marker

    public lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        databaseRef = Firebase.database.reference
        databaseRef.addValueEventListener(logListener)

    }

    private val logListener = object : ValueEventListener {
        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(applicationContext, "Could not read from database", Toast.LENGTH_LONG)
                    .show()
        }
        override fun onDataChange(dataSnapshot: DataSnapshot) {

            if (dataSnapshot.exists()) {

                mMap.clear() //to remove prev marker after loc change

                val intent = intent
                val bus = intent.getStringExtra("id")
                val seatsCount: TextView = findViewById(R.id.bus_seats)

                val locationLogging = dataSnapshot.child(bus.toString()).getValue(LocationLogging::class.java)
                val driverLat=locationLogging?.Latitude
                val driverLong=locationLogging?.Longitude

                    if((locationLogging?.Seats).toString()=="true")
                    {
                        seatsCount.text = "SEATS ARE FULL"
                    }
                    else{
                        seatsCount.text = "SEATS ARE AVAILABLE"
                    }

                if (driverLat !=null  && driverLong != null) {
                    val driverLoc = LatLng(driverLat, driverLong)
                    val markerOptions = MarkerOptions().position(driverLoc).title(bus.toString()).icon(
                            BitmapDescriptorFactory.fromResource(R.drawable.markerm)
                    )
                    //markerm.png is the bus icon

                    mMap.addMarker(markerOptions)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(driverLoc, 16.5f))
                    //Zoom level - 1: World, 5: Landmass/continent, 10: City, 15: Streets and 20: Buildings

                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

}
