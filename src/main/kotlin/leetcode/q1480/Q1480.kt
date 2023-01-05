package leetcode.q1480

import java.util.*

fun main() {
    val result = runningSum(intArrayOf(1,2,3,4))
    println(result.contentToString())
}

fun runningSum(nums: IntArray): IntArray {
    if(nums.size == 1) {
        return nums
    }
    for (i in 1 until nums.size) {
        nums[i] += nums[i-1]
    }
    return nums
}