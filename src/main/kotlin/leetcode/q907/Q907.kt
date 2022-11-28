package leetcode.q907

// https://leetcode.com/problems/sum-of-subarray-minimums/

class Q907 {
}


fun main() {
    val sumSubarrayMins = sumSubarrayMins(intArrayOf(11, 81, 94, 43, 3))
    println(sumSubarrayMins)
}

val M = 1_000_000_007
fun sumSubarrayMins(arr: IntArray): Int {
    val n = arr.size

    val d = IntArray(n)

    if (arr.isEmpty()) {
        return 0
    }

    if (arr.size == 1) {
        return arr.single()
    }

    d[0] = arr[0]
    d[1] = d[0] + arr[1] + Math.min(arr[0], arr[1])

    for (i in 2 until n) {
        d[i] = d[i - 1] + minSumValue(arr, i)

        if (d[i] >= M) {
            d[i] %= M
        }
    }

    return d[n - 1]
}

// 0 -> arr[0]
// 1 -> min(arr(1), arr(0)), min(arr(1))
// 2 -> min(arr(2), arr(1), arr(0)) + min(arr(2), arr(1)) + min(arr(2))
fun minSumValue(arr: IntArray, idx: Int): Int {
    val d = IntArray(idx + 1)

    d[0] = arr[idx]

    for (i in 1..idx) {
        d[i] = Math.min(d[i - 1], arr[idx - i])
    }

    return d.sum()
}
