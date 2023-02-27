package com.cvillarreal.liftpro.controller

import com.cvillarreal.liftpro.service.UserService
import com.fasterxml.jackson.databind.node.ObjectNode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/user")
class UserController(
    private val userService: UserService
) {

    /**
     * Create a new user
     * @param json The JSON object containing the user's email and password.
     TODO: Add validation for email and password and encryption
     * @return 200 with the ID of the new user.
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody json: ObjectNode): String {
        val email = json.get("email").asText()
        val password = json.get("password").asText()
        val newUserID = userService.createNewUser(email, password)
        println("New user created with ID $newUserID")
        return newUserID.toString()
    }

    /**
     * Get user by id
     * @param id The ID of the user to retrieve.
     * @return 200 with list of users, 404 if no users are found.
     */
    @GetMapping("{id}")
    fun getUserByID(@PathVariable("id") id: UUID): ResponseEntity<Any> {
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
    @DeleteMapping("{id}")
    fun deleteUserByID(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        val userDeleted = userService.deleteUser(id)
        val allUsers = userService.getUsers()
        println("$userDeleted $id $allUsers")
        // If user is not found, return 404 with message "User with ID $id not found"
        if (!userDeleted) {
            return ResponseEntity.notFound().build()
        }
        // If user is found, return 200 with message "User with ID $id deleted"
        return ResponseEntity.status(200).body("User with ID $id deleted")
    }
}