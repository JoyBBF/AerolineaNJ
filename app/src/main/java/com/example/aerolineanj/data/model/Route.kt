package com.example.aerolineanj.data.model

import java.io.Serializable

data class Route (
    var id: Int,
    var origin: String,
    var destination: String,
    var duration: Int
    ) : Serializable