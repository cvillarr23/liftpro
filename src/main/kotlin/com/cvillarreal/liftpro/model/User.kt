package com.cvillarreal.liftpro.model

import java.util.UUID

data class User(
    val id: UUID,
    val email: String,
    val password: String
)