package com.example.aerolineanj.data.model

data class Reservation (
    var id: Int,
    var price: Double,
    var cliente: User,
    var flight: Flight
        )