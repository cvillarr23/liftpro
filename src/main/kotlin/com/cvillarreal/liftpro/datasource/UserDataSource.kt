package com.cvillarreal.liftpro.datasource

import com.cvillarreal.liftpro.model.User

interface UserDataSource {
    fun getUsers(): Collection<User>
}