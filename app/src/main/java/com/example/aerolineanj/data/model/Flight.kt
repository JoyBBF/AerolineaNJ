package com.example.aerolineanj.data.model

import java.util.*

data class Flight (
    var id: Int,
    var departureDate: Date,
    var returnDate: Date,
    var schedule: Schedule
)
