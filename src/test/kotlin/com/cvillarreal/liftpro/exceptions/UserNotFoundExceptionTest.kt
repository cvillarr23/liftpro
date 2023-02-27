package com.cvillarreal.liftpro.exceptions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserNotFoundExceptionTest {
    @Test
    fun `should retrieve message using getMessage`() {
        val message = "User not found"
        val exception = UserNotFoundException(message)
        assertThat(exception.message).isEqualTo(message)
     }
}