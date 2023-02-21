package com.cvillarreal.liftpro.model.weights

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WeightTest {

    @Test
    fun `should return the weight in kg`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)

        // then
        assertEquals(0.0, w1.weightKg)
        assertEquals(1.0, w2.weightKg)
     }

    @Test
    fun `should return the converted weight in lbs`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)

        // then
        assertEquals(0.0, w1.toPounds())
        assertEquals(2.20462, w2.toPounds())

     }

    @Test
    fun `should return a string representation in kg`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)


        // then
        assertEquals("0.0 kg", w1.toStringKg())
        assertEquals("1.0 kg", w2.toStringKg())

     }

    @Test
    fun `should return a string representation in lb`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)

        // then
        assertEquals("0.0 lb", w1.toStringLb())
        assertEquals("2.2 lb", w2.toStringLb())

     }

    @Test
    fun `should not allow negative weights`() {
        try {
            Weight(-1.0)
            fail("Should not allow negative weights")
        } catch (e: IllegalArgumentException) {
            // expected
        }
     }











}