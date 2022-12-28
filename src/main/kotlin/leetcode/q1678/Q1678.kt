package leetcode.q1678

// https://leetcode.com/problems/goal-parser-interpretation/description/
class Solution {
    fun interpret(command: String): String {
        val result = StringBuilder()
        var isO = false

        for (c in command) {
            when (c) {
                'G' -> result.append("G")
                '(' -> isO = true
                'a' -> isO = false
                ')' -> if (isO) result.append("o") else result.append("al")
            }
        }

        return result.toString()
    }
}