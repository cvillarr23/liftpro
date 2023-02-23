package com.cvillarreal.liftpro.model

import java.util.*

data class User(
    var id: UUID,
    val email: String,
    val password: String
)