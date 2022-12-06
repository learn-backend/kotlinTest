package leetcode.q35

import leetcode.q13.Q13

//https://leetcode.com/problems/search-insert-position/
fun main() {
    val nums = intArrayOf(1,3,5,6)
    val searchInsert = searchInsert(nums,7)
    println(searchInsert)
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size-1

    while (start <= end) {
        val mid = start + (end-start)/2

        if(nums[mid] == target)
            return mid

        if (target < nums[mid])
            end = mid-1
        else
            start = mid+1
    }
    return start
}