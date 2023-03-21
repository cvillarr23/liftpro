package com.cvillarreal.liftpro.model.weights

import org.hamcrest.Matchers.closeTo
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WeightTest {

    @Test
    fun `should construct and convert weight in kilograms`() {
        // when
        val w1 = Weight(0.0, WeightUnit.KILOGRAMS)
        val w2 = Weight(1.0, WeightUnit.KILOGRAMS)

        // then
        assertEquals(0.0, w1.toKilogram())
        assertEquals(1.0, w2.toKilogram(), 0.001)
        assertEquals(0.0, w1.weightLb)
        assertEquals(2.20462, w2.weightLb, 0.001)
     }

    @Test
    fun `should return construct and convert weight in lbs`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)

        // then
        assertEquals(0.0, w1.weightLb, 0.001)
        assertEquals(1.0, w2.weightLb, 0.001)
        assertEquals(0.0, w1.toKilogram())
        assertEquals(0.453, w2.toKilogram(), 0.001)
     }

    @Test
    fun `should return a string representation in kg`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)


        // then
        assertEquals("0.0 kg", w1.toStringKg())
        assertEquals("0.5 kg", w2.toStringKg())

     }

    @Test
    fun `should return a string representation in lb`() {
        // when
        val w1 = Weight(0.0)
        val w2 = Weight(1.0)

        // then
        assertEquals("0.0 lb", w1.toStringLb())
        assertEquals("1.0 lb", w2.toStringLb())

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