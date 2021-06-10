package com.example.aerolineanj.data.model

data class Ticket (
    var id: Int,
    var row: Int,
    var column: Int,
    var reservation: Reservation
    )