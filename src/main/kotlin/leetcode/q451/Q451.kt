package leetcode.q451

// https://leetcode.com/problems/sort-characters-by-frequency/

fun main() {
    val frequencySort = Q451.frequencySort("cccaaa")
    println(frequencySort)
}

object Q451 {
    fun frequencySort(s: String): String {
        val map = s.toList().groupingBy { it }.eachCount()

        val descendingKeys = map.keys.asSequence().sortedByDescending { k -> map[k] }

        return descendingKeys.joinToString(separator = "") { k ->
            k.toString().repeat(map.getValue(k))
        }
    }
}
