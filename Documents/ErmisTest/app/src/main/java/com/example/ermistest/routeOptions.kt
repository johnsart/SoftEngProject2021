package com.example.ermistest

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalTime

class routeOptions : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_options)

       // val intent = getIntent()
        //val routeOption = intent.getStringExtra("RouteOption")
        val routeOption = ""
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup2)
        val selectOptionRoute = findViewById<Button>(R.id.buttonSelectOptionRoute)
        val optionSafe = findViewById<RadioButton>(R.id.buttonSafe)
        val optionFast = findViewById<RadioButton>(R.id.buttonFast)
        var check = false
        var vehicle = transport.none
        val startTime = LocalTime.now()
        val destinationTime = LocalTime.now()
        var locationLongitude : Float = 0f
        var locationLatitude : Float = 0f
        var destinationLatitude : Float = 1f
        var destinationLongitude : Float = 1f
        var startStationLongitude : Float = 0f
        var startStationLatitude : Float = 0f

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if (rb != null)
                check = true
        }
        optionSafe.setOnClickListener {
            vehicle = transport.bikeOrByFoot
        }
        optionFast.setOnClickListener {
            vehicle = transport.car
        }
        selectOptionRoute.setOnClickListener {
            if (!check) {
                val toast1 = Toast.makeText(
                    applicationContext,
                    "Please select an option.",
                    Toast.LENGTH_LONG
                )
                toast1.setGravity(Gravity.CENTER, 0, 0)
                toast1.show()
            }
            else {
                if (routeOption == "safe") {
                    var route = SafeRoute(
                        startLongitute = startStationLongitude,
                        startLatitude = startStationLatitude,
                        destinationLongitute = destinationLongitude,
                        destinationLatitude = destinationLongitude,
                        transportMeans = transport.MMM,
                        startTime = startTime,
                        endTime = destinationTime,
                        MMMInfo = "732"
                    )
                    val toast1 = Toast.makeText(
                        applicationContext,
                        "safe MMM.",
                        Toast.LENGTH_LONG
                    )
                    toast1.setGravity(Gravity.CENTER, 0, 0)
                    toast1.show()
                }
                else if (routeOption == "fast") {
                    var route = FastRoute(
                        startLongitute = startStationLongitude,
                        startLatitude = startStationLatitude,
                        destinationLongitute = destinationLongitude,
                        destinationLatitude = destinationLatitude,
                        transportMeans = transport.MMM,
                        startTime = startTime,
                        endTime = destinationTime,
                        MMMInfo = "732"
                    )
                    val toast1 = Toast.makeText(
                        applicationContext,
                        "fast MMM.",
                        Toast.LENGTH_LONG
                    )
                    toast1.setGravity(Gravity.CENTER, 0, 0)
                    toast1.show()
                }
                if (vehicle == transport.bikeOrByFoot) {
                    if (routeOption == "safe") {
                        var route = SafeRoute(
                            startLongitute = locationLongitude,
                            startLatitude = locationLatitude,
                            destinationLongitute = startStationLongitude,
                            destinationLatitude = startStationLatitude,
                            transportMeans = transport.bikeOrByFoot,
                            startTime = startTime,
                            endTime = destinationTime,
                            MMMInfo = ""
                        )
                        val toast1 = Toast.makeText(
                            applicationContext,
                            "safe and bike.",
                            Toast.LENGTH_LONG
                        )
                        toast1.setGravity(Gravity.CENTER, 0, 0)
                        toast1.show()
                    }
                    else if (routeOption == "fast") {
                        var route = FastRoute(
                            startLongitute = locationLongitude,
                            startLatitude = locationLatitude,
                            destinationLongitute = startStationLongitude,
                            destinationLatitude = startStationLatitude,
                            transportMeans = transport.bikeOrByFoot,
                            startTime = startTime,
                            endTime = destinationTime,
                            MMMInfo = ""
                        )
                        val toast1 = Toast.makeText(
                            applicationContext,
                            "fast and bike.",
                            Toast.LENGTH_LONG
                        )
                        toast1.setGravity(Gravity.CENTER, 0, 0)
                        toast1.show()
                    }
                    else {
                        val toast1 = Toast.makeText(
                            applicationContext,
                            "Something went wrong.",
                            Toast.LENGTH_LONG
                        )
                        toast1.setGravity(Gravity.CENTER, 0, 0)
                        toast1.show()
                    }
                }
                val intent = Intent(this, routeOptions::class.java)
                startActivity(intent)
            }
        }
    }
}