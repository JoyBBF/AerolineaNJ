package com.example.aerolineanj.data.model

import androidx.annotation.Nullable
import java.util.*

data class Flight (
    var id: Int,
    var departureDate: Date,
    var returnDate: Date?,
    var schedule: Schedule
)
