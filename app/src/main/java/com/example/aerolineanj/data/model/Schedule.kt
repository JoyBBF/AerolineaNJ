package com.example.aerolineanj.data.model

import java.io.Serializable
import java.time.LocalTime

data class Schedule (
    var id: Int,
    var day: String,
    var time: LocalTime,
    var price: Int,
    var discount: Int,
    var plane: Plane,
    var route: Route
    ) : Serializable
