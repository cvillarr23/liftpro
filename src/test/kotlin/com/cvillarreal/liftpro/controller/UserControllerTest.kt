package com.cvillarreal.liftpro.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
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
            post("/api/v1/user/$id")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect {
                status().isOk
                jsonPath("$.id").value(id.toString())
                jsonPath("$.email").value("test")
                jsonPath("$.password").value("test")
            }
    }


//    @Test
//    fun `should be able to delete a user`() {
//        val result = mockMvc.perform(
//            post("/api/v1/user/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"email\": \"test\", \"password\": \"test\"}")
//        ).andExpect(
//            status().isOk
//        ).andReturn()
//
//        // Check that result is a valid UUID string, if not, this will throw an exception
//        val id = UUID.fromString(result.response.contentAsString)
//
//        // Try to delete the user by ID
//        mockMvc.perform(
//            delete("/api/v1/user/$id")
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//            .andExpect {
//                status().isOk
//            }
//
//        // Try to delete the user again, should fail
//        mockMvc.perform(
//            delete("/api/v1/user/$id")
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//            .andExpect {
//                status().isNotFound
//            }
//
//     }


}