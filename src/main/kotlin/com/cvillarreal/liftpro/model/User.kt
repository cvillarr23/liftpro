package com.cvillarreal.liftpro.model

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class User(
    var id: UUID? = null,
    val email: String,
    val password: String
)