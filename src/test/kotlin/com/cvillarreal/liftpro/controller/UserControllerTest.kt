package com.cvillarreal.liftpro.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should create a user that can be identified by the returned ID`() {

        val result = mockMvc.perform(
            post("/api/v1/user/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\": \"test\", \"password\": \"test\"}")
        )
            .andExpect {
                status().isCreated
            }.andReturn()

        assertThat(result.response.contentAsString).isNotEmpty
        assertThat(result.response.contentAsString).isNotBlank

        // Check that result is a valid UUID string, if not, this will throw an exception
        val id = UUID.fromString(result.response.contentAsString)

        // Try to retrieve the user by ID
        mockMvc.perform(
            get("/api/v1/user/$id")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect {
                status().isOk
                jsonPath("$.id").value(id.toString())
                jsonPath("$.email").value("test")
                jsonPath("$.password").value("test")
            }
    }

    @Test
    fun `should return 404 when trying to retrieve a user with invalid ID`() {
        //given
        val id = UUID.randomUUID()

        // when
        val result = mockMvc.perform(
            get("/api/v1/user/$id")
        )
            .andExpect {
                status().isNotFound
            }.andReturn()
     }


    @Test
    fun `should return 404 when trying to delete a user with invalid ID`() {
        //given
        val id = UUID.randomUUID()

        // when
        mockMvc.perform(
            delete("/api/v1/user/$id")
        )
            .andExpect {
                status().isNotFound
            }
     }

    @Test
    fun `should delete user by ID`() {
        val defaultID = UUID(0,0)
        // when
        mockMvc.perform(
            delete("/api/v1/user/$defaultID")
        ).andExpect(
            status().isOk
        )

        // then
        mockMvc.perform(
            get("/api/v1/user/$defaultID"))
            .andExpect (
                status().isNotFound
            )
     }
}