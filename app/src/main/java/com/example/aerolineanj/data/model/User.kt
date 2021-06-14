package com.example.aerolineanj.data.model

import java.io.Serializable
import java.sql.Date

data class User (
    var username: String,
    var name: String,
    var lastName: String,
    var password: String,
    var email: String,
    var birth: Date,
    var sex: Int,
    var workPhone: Int,
    var cellPhone: Int,
    var direction: String,
    var type: Int
    ) : Serializable