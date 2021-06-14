package com.example.aerolineanj.data.model

import androidx.annotation.Nullable
import java.io.Serializable
import java.util.*

data class Flight (
    var id: Int,
    var departureDate: Date,
    var returnDate: Date?,
    var schedule: Schedule
) : Serializable
