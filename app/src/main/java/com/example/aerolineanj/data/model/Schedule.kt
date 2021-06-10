package com.example.aerolineanj.data.model

import java.sql.Date

data class Schedule (
    var id: Int,
    var day: String,
    var time: Date,
    var price: Double,
    var discount: Double,
    var plane: Plane,
    var route: Route
){

}
