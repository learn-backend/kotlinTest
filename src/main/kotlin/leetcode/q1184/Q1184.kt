package leetcode.q1184

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
        var count = 0
        for (i in start until end) {
            count += distance[i]
        }
        return count
    }
}