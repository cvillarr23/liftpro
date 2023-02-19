package com.cvillarreal.LiftPro.datasource

import com.cvillarreal.LiftPro.model.User

interface UserDataSource {
    fun getUsers(): Collection<User>
}