package com.example.aerolineanj.data.model

import java.io.Serializable

data class Plane (
    var id: Int,
    var year: Int,
    var model: String,
    var brand: String,
    var planeType: PlaneType
    ) : Serializable