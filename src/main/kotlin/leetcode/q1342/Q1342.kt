package leetcode.q1342

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
class Solution {
    fun numberOfSteps(num: Int): Int {
        var num1 = num
        var count = 0

        while (num1 != 0) {
            num1 = when (num1 % 2 == 0) {
                true -> num1 / 2
                false -> num1 - 1
            }
            count ++
        }

        return count
    }
}