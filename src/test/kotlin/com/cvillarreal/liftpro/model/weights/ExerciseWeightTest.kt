package com.cvillarreal.liftpro.model.weights

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ExerciseWeightTest {
    // Test cases
    companion object {
        @JvmStatic
        fun calculatePlatesForLbsTestCases() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(135.0, listOf(Weight(45.0))),
                Arguments.of(175.0, listOf(Weight(45.0), Weight(10.0), Weight(10.0))),
                Arguments.of(45.0, emptyList<Weight>()),
                Arguments.of(48.1, listOf(Weight(1.25)))
            )
        }

        @JvmStatic
        fun calculatePlatesForKgTestCases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(60.0, listOf(Weight(20.0, WeightUnit.KILOGRAMS))),
                Arguments.of(20.0, emptyList<Weight>()),
                Arguments.of(21.0, listOf(Weight(0.5, WeightUnit.KILOGRAMS))),
                Arguments.of(22.0, listOf(Weight(1.0, WeightUnit.KILOGRAMS))),
                Arguments.of(23.1, listOf(
                    Weight(1.0, WeightUnit.KILOGRAMS), Weight(0.5, WeightUnit.KILOGRAMS))),
            )
        }
    }

    @Test
    fun `should not allow negative weight in constructor`() {
        assertThrows(IllegalArgumentException::class.java) {
            ExerciseWeight(
                totalWeight = Weight(-1.0)
            )
        }
     }

    @Test
    fun `should not allow larger baseWeight than totalWeight in constructor`() {
        assertThrows(IllegalArgumentException::class.java) {
            ExerciseWeight(
                totalWeight = Weight(0.0),
                baseWeight = BaseWeight("Barbell (20kg/45lb)", Weight(20.0))
            )
        }
     }

    @Test
    fun `should contain a totalWeight and baseWeight less than totalWeight`() {
        // when
        val w1 = ExerciseWeight(
            totalWeight = Weight(0.0)
        )
        assertEquals(w1.totalWeight.weightLb, 0.0, 0.001)
        assertNull(w1.baseWeight)

        val w2 = ExerciseWeight(
            totalWeight = Weight(46.0),
            baseWeight = BaseWeight("Barbell (20kg/45lb)", Weight(20.0))
        )

        assertEquals(w2.totalWeight.weightLb, 46.0, 0.001)
        w2.baseWeight?.weight?.weightLb?.let { assertEquals(it, 20.0, 0.001) }



        // then


     }

    @Test
    fun `should be able to convert total weight to kilograms`() {
        // when
        val w1 = ExerciseWeight(
            totalWeight = Weight(0.0)
        ).toKilogram()

        assertEquals(w1, 0.0, 0.001)

        val w2 = ExerciseWeight(
            totalWeight = Weight(1.0)
        ).toKilogram()
        assertEquals(w2, 0.453, 0.001)
     }

    @ParameterizedTest(name = "should calculate plates for kilograms {0} = {1}")
    @MethodSource("calculatePlatesForKgTestCases")
    fun `should calculate plates for kilograms`(totalWeight: Double, expected: List<Weight>) {
        // when
        val actual = ExerciseWeight(
            totalWeight = Weight(totalWeight, WeightUnit.KILOGRAMS),
            baseWeight = BaseWeight("Barbell (20kg/45lb)", Weight(20.0, WeightUnit.KILOGRAMS))
        ).calculatePlates(unit = WeightUnit.KILOGRAMS)
        // then assert the list of plates is the same as the expected
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertEquals(expected[i].toStringKg(), actual[i].toStringKg())
        }
     }

    @ParameterizedTest(name = "should calculate plates for lbs {0} = {1}")
    @MethodSource("calculatePlatesForLbsTestCases")
    fun `should calculate plates for lbs`(totalWeight: Double, expected: List<Weight>) {
        // when
        val actual = ExerciseWeight(
            totalWeight = Weight(totalWeight),
            baseWeight = BaseWeight("Barbell (20kg/45lb)", Weight(45.0, WeightUnit.POUNDS))
            ).calculatePlates()

        // then assert the list of plates is the same as the expected
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertEquals(expected[i].weightLb, actual[i].weightLb)
        }
     }








}