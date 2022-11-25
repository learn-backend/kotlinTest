package leetcode.q1184

import kotlin.math.max
import kotlin.math.min

// https://leetcode.com/problems/distance-between-bus-stops/
class Q1184 {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        val stops = distance.size

        return if (start == destination) {
            0
        } else {
            val min = min(start, destination)
            val max = max(start, destination)
            val sumBeforeMin = addBetween(distance, 0, min)
            val sumBetweenMinAndMax = addBetween(distance, min, max)
            val sumAfterMax = addBetween(distance, max, stops)
            min(sumBeforeMin + sumAfterMax, sumBetweenMinAndMax)
        }
    }

    private fun addBetween(distance: IntArray, start: Int, end: Int): Int {
        return (start until end).fold(0) { acc, i -> acc + distance[i] }
    }
}