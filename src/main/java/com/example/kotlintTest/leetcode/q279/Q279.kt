package com.example.kotlintTest.leetcode.q279

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val result = Q279.numSquares(13)
    println(result)

}

object Q279 {

    fun numSquares(n: Int): Int {

        var num = n
        var cnt = 0

        while (num != 0) {
            val sqrt = sqrt(num.toDouble()).toInt()
            val pow = sqrt.toDouble().pow(2).toInt()

            num -= pow
            cnt++
        }
        return cnt
    }
}