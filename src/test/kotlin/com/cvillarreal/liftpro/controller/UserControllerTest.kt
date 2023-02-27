package com.cvillarreal.liftpro.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.delete
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
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
                status().isOk
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
        val result = mockMvc.get("/api/v1/user/$id")
            .andExpect {
                status().isNotFound
            }
     }


    @Test
    fun `should return 404 when trying to delete a user with invalid ID`() {
        //given
        val id = UUID.randomUUID()

        // when
        mockMvc.delete("/api/v1/user/$id")
            .andExpect {
                status().isNotFound
            }
     }

    @Test
    fun `should delete user after calling the delete user by ID endpoint`() {
        //given
        val result = mockMvc.perform(
            post("/api/v1/user/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\": \"test\", \"password\": \"test\"}")
        ).andExpect(
            status().isOk
        ).andReturn()

        // Check that result is a valid UUID string, if not, this will throw an exception
        val id = UUID.fromString(result.response.contentAsString)

        // when
        mockMvc.delete("/api/v1/user/$id")
            .andExpect {
                status().isOk
            }

        // then
        mockMvc.get("/api/v1/user/$id")
            .andExpect {
                status().isNotFound
            }
     }
}