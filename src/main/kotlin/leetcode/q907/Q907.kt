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
    val stack = IntArray(n + 1)

    if (arr.isEmpty()) {
        return 0
    }

    if (arr.size == 1) {
        return arr.single()
    }

    var idxStack = 0

    d[0] = arr[0]

    var res = d[0].toLong()

    for (i in 1 until n) {
        // idxStack 값이 위치한 곳은 최소 값
        // idxStack이 -1 이면, arr[i] 값이 가장 작음
        while (idxStack >= 0 && arr[stack[idxStack]] >= arr[i]) {
            idxStack--
        }

        // arr[i] 값이 가장 작으면, arr[i] * 추가되는 횟수(i+1)
        // 그 외 더 작은 값이 있으면 해당 최소 값 합 + 그 사이의 추가된 횟수
        d[i] = if (idxStack < 0) arr[i] * (i + 1) else d[stack[idxStack]] + arr[i] * (i - stack[idxStack])
        stack[++idxStack] = i
        res += d[i]
    }

    return (res % M).toInt()
}
