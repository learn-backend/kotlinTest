package leetcode.q1678

// https://leetcode.com/problems/goal-parser-interpretation/description/
class Solution {
    fun interpret(command: String): String {
        val result = StringBuilder()
        var isO = false

        // 정규식으로도 풀 수 있음
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