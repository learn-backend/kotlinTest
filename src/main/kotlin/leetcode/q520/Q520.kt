package leetcode.q520

// https://leetcode.com/problems/detect-capital/description/
fun main() {
//    Q520.detectCapitalUse("FlaG")
//    Q520.detectCapitalUse("USA")
    Q520.detectCapitalUse("NIy")
}

object Q520 {

    fun detectCapitalUse(word: String): Boolean {
        if (word.isAllUpperCase()) {
            return true
        }

        if (word.isAllLowerCase()) {
            return true
        }


        if (word.isAllUpperCase()) {
            return true
        }

        if (word.isFirstUpperAndLowerCase()) {
            return true
        }

        return false
    }

    private fun String.isAllUpperCase(): Boolean {
        return this.toCharArray().all { it in 'A'..'Z' }
    }

    private fun String.isAllLowerCase(): Boolean {
        return this.toCharArray().all { it in 'a'..'z' }
    }

    private fun String.isFirstUpperAndLowerCase(): Boolean {
        if ((this.first() !in 'A'..'Z')) {
            return false
        }


        val extraWords = this.removeRange(IntRange(0, 0))

        return extraWords.isAllLowerCase()
    }
}
