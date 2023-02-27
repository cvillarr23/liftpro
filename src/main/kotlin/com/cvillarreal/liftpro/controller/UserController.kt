package com.cvillarreal.liftpro.controller

import com.cvillarreal.LiftPro.datasource.mock.MockUserDataSource
import com.cvillarreal.LiftPro.service.UserService
import com.fasterxml.jackson.databind.node.ObjectNode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/user")
class UserController {

    /**
     * Create a new user
     * @param json The JSON object containing the user's email and password.
     TODO: Add validation for email and password and encryption
     * @return 200 with the ID of the new user.
     */
    @PostMapping("/new")
    fun createUser(@RequestBody json: ObjectNode): String {
        val email = json.get("email").asText()
        val password = json.get("password").asText()
        val userService = UserService(MockUserDataSource())
        val newUserID = userService.createNewUser(email, password)
        return newUserID.toString()
    }

    /**
     * Get user by id
     * @param id The ID of the user to retrieve.
     * @return 200 with list of users, 404 if no users are found.
     */
    @GetMapping("/{id}")
    fun getUserByID(@RequestBody id: UUID): ResponseEntity<Any> {
        val userService = UserService(MockUserDataSource())
        // If user is not found, return 404 with message "User with ID $id not found"
        val user = userService.getUserByID(id) ?:
            return ResponseEntity.notFound().build()
        // If user is found, return 200 with user object
        return ResponseEntity.status(200).body(user)
    }

    /**
     * Delete user by ID
     * @param id The ID of the user to delete.
     * @return 200 if user was deleted, 404 if user was not found.
     */
    @DeleteMapping("/{id}")
    fun deleteUserByID(@RequestBody id: UUID): ResponseEntity<Any> {
        val userService = UserService(MockUserDataSource())
        return if(userService.deleteUser(id)) {
            ResponseEntity.status(200).build()
        } else {
            ResponseEntity.status(404).build()
        }
    }
}