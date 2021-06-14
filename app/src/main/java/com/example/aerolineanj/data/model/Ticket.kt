package com.example.aerolineanj.data.model

import java.io.Serializable

data class Ticket (
    var id: Int,
    var row: Int,
    var column: Int,
    var reservation: Reservation
    ) : Serializable