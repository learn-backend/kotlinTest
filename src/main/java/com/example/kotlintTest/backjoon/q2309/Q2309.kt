package com.example.kotlintTest.backjoon.q2309


class Q2309 {
    fun sum(heights: MutableList<Int>, n1: Int, n2: Int): Int {
        var ret = 0
        for (i in heights.indices) {
            if (i == n1 || i == n2) continue
            ret += heights[i]
        }
        return ret
    }

    fun main(args: Array<String>) {
        val heights = mutableListOf<Int>()
        for (i in 0..8) {
            val sc = readLine()!!.toInt()
            heights.add(sc)
        }

        var n1 = 0
        var n2 = 0
        for (i in 0..8) {
            for (j in i + 1..8) {
                if (100 == sum(heights, i, j)) {
                    n1 = i
                    n2 = j
                }
            }
        }

        heights.removeAt(n2)
        heights.removeAt(n1)
        heights.sorted().forEach {
            println(it)
        }
    }
}