package leetcode.q438

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
fun main() {
    val solution = Solution()
    val s = "cbaebabacd"
    val p = "abc"
    println(solution.findAnagrams(s, p))
}

class Solution {
    private var uniqueCount: Int = 0
    private val counts = HashMap<Char, Int>()

    fun findAnagrams(s: String, p: String): List<Int> {
        val pLength = p.length
        val result = ArrayList<Int>()

        if (s.length < pLength) return result

        for (c: Char in p) {
            if (!counts.containsKey(c)) {
                uniqueCount += 1
                counts[c] = 1
            }
            else {
                counts[c] = counts[c]!! + 1
            }
        }

        for (i: Int in s.indices) {
            if (i >= p.length) this.addCountIfPresent(s[i - p.length])
            this.subCountIfPresent(s[i])
            if (uniqueCount == 0) result.add(i - p.length + 1)
        }

        return result
    }

    private fun subCountIfPresent(target: Char) {
        if (counts.containsKey(target)) {
            counts[target] = counts[target]!! - 1
            if (counts[target] == 0) {
                uniqueCount--
            }
        }
    }

    private fun addCountIfPresent(target: Char) {
        if (counts.containsKey(target)) {
            if (counts[target] == 0) {
                uniqueCount++
            }
            counts[target] = counts[target]!! + 1
        }
    }
}