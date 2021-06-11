package com.example.aerolineanj.data.model

data class Reservation (
    var id: Int,
    var price: Double,
    var client: User,
    var flight: Flight
        )