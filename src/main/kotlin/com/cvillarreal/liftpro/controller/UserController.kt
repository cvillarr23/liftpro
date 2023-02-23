package com.cvillarreal.liftpro.controller

import com.cvillarreal.LiftPro.datasource.mock.MockUserDataSource
import com.cvillarreal.LiftPro.service.UserService
import com.cvillarreal.liftpro.model.User
import com.fasterxml.jackson.databind.node.ObjectNode
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/user")
class UserController {

    @PostMapping("/new")
    fun createUser(@RequestBody json: ObjectNode): String {
        val email = json.get("email").asText()
        val password = json.get("password").asText()
        val userService = UserService(MockUserDataSource())
        val newUserID = userService.createNewUser(email, password)
        return newUserID.toString()
    }

    // Get user by ID
    @GetMapping("/{id}")
    fun getUserByID(@RequestBody id: UUID): User {
        return User(UUID.randomUUID(),"test", "test")

    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    fun deleteUserByID(@RequestBody id: UUID) {
        TODO("Not yet implemented")
    }
}