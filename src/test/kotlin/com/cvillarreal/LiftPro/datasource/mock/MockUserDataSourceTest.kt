package com.cvillarreal.LiftPro.datasource.mock


import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MockUserDataSourceTest {

    private val mockDataSource = MockUserDataSource()

    @Test
    fun `should provide a list of all users`() {
        //given


        // when
        val users = mockDataSource.getUsers()


        // then
        // Check that there are users
        Assertions.assertThat(users).isNotEmpty
        Assertions.assertThat(users).extracting("id").isNotNull

     }

    @Test
    fun `should have `() {
        //given
        
        
        // when
        
        
        // then
        
        
     }
        
        


}