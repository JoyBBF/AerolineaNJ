package com.example.aerolineanj.data.model

import java.io.Serializable

data class PlaneType (
    var id: Int,
    var rows: Int,
    var columns: Int
    ) : Serializable