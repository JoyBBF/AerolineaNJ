package com.example.aerolineanj.data.model

import java.io.Serializable
import java.text.FieldPosition

data class Seat(
    var row: Int,
    var column: Int,
    var available: Boolean
) : Serializable
