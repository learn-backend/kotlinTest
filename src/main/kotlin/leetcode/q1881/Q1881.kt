package leetcode.q1881

// https://leetcode.com/problems/maximum-value-after-insertion/
fun main() {
    println(Solution.maxValue("-13", 2))
}

object Solution {
    fun maxValue(n: String, x: Int): String {
        val charX = x.toString()[0]
        val isPositive = n[0] != '-'
        val length = n.length

        val candidate:Int?
        val targetIndex = when(isPositive) {
            true -> {
                candidate = n.indices.find { n[it] < charX }
                candidate ?: length
            }
            false -> {
                candidate = n.indices.find { n[it] != '-' && n[it] > charX }
                candidate ?: length
            }
        }

        return StringBuilder(n.substring(0, targetIndex)).append(x.toString()).append(n.substring(targetIndex, length)).toString()
    }
}