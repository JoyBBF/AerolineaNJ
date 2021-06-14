package com.example.aerolineanj.data.model

import java.io.Serializable

data class Reservation (
    var id: Int,
    var price: Double,
    var client: User,
    var flight: Flight
    ) : Serializable