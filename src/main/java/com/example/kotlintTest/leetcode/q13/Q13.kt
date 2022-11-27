package com.example.kotlintTest.leetcode.q279.q13


fun main() {
    val romanToInt = Q13.romanToInt("LVIII")
    println(romanToInt)
}

object Q13 {

    val pairs: Map<Char, Int> = mapOf(
        Pair('I', 1),
        Pair('V', 5),
        Pair('X', 10),
        Pair('L', 50),
        Pair('C', 100),
        Pair('D', 500),
        Pair('M', 1000)
    )

    val specialPairs: Map<String, Int> = mapOf(
        Pair("IV", 4),
        Pair("IX", 9),
        Pair("XL", 40),
        Pair("XC", 90),
        Pair("CD", 400),
        Pair("CM", 900)
    )


    fun romanToInt(s: String): Int {
        var anw = 0
        var buf: Char? = null
        val q: MutableList<Char> = mutableListOf()


        s.toCharArray().forEach { c ->
            if (buf == null) {
                buf = c
                q.add(c)
            } else if (buf == c) {
                q.add(c)

            } else if (specialPairs.containsKey(buf.toString() + c.toString())) {
                anw += specialPairs.getValue(buf.toString() + c.toString())

                buf = null
                q.clear()
            } else {
                anw += pairs.getValue(buf!!) * q.size

                buf = c
                q.clear()
                q.add(c)
            }
        }

        if (q.isNotEmpty()) {
            anw += pairs.getValue(buf!!) * q.size
        }


        return anw
    }

}