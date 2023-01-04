package leetcode.q2244

// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
class Solution {
    fun minimumRounds(tasks: IntArray): Int {
        var result = 0
        val counts:MutableMap<Int, Int> = HashMap()
        tasks.forEach { t -> counts[t] = counts.getOrDefault(t, 0) + 1 }

        for (count:Int in counts.values) {
            val taskCount = this.getTaskCount(count)
            if (taskCount == 0) return -1
            else result += taskCount
        }
        return result
    }

    private fun getTaskCount(count:Int):Int {
        var twoCount = 0
        var multipleOf2 = 0
        while(multipleOf2 <= count) {
            multipleOf2 = twoCount * 2
            if (multipleOf2 == count) return twoCount
            if ((count - multipleOf2) % 3 == 0) return twoCount + ((count - multipleOf2) / 3)
            twoCount++
        }
        return 0
    }
}