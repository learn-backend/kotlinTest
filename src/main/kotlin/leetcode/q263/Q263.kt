package leetcode.q263

// https://leetcode.com/problems/ugly-number/
class Q263 {

    fun isUgly(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        var result = n

        while (result > 1) {
            result /= if (result % 2 == 0) {
                2
            } else if (result % 3 == 0) {
                3
            } else if (result % 5 == 0) {
                5
            } else {
                return false
            }
        }

        return true
    }
}
