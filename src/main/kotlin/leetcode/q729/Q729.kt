package leetcode.q729

class MyCalendar {
    val dayStateList: MutableList<Date> = mutableListOf()

    fun book(start: Int, end: Int): Boolean {
        val upperBound = this.getUpperBound(start)

        if (upperBound == null) {
            dayStateList.add(dayStateList.size, Date(start, DayType.START))
            dayStateList.add(dayStateList.size, Date(end, DayType.END))
            return true
        }

        val upperBoundDate = dayStateList[upperBound]

        if (upperBoundDate.state == DayType.END || upperBoundDate.day < end) {
            return false
        }

        if (upperBound != 0) {
            val beforeUpperBoundDate = dayStateList[upperBound - 1]
            if (beforeUpperBoundDate.state == DayType.START || beforeUpperBoundDate.day > start) {
                return false
            }
        }

        dayStateList.add(upperBound, Date(start, DayType.START))
        dayStateList.add(upperBound + 1, Date(end, DayType.END))
        return true
    }

    private fun getUpperBound(target: Int):Int? {
        if (dayStateList.isEmpty()) return null
        if (dayStateList[dayStateList.size - 1].day <= target) return null

        var left = 0
        var right = dayStateList.size - 1

        while (left < right) {
            val mid = (left + right) / 2
            if (dayStateList[mid].day <= target) {
                left = mid + 1
                continue
            }
            else if (dayStateList[mid].day > target) {
                right = mid
                continue
            }
        }

        return right
    }


}

class Date (
    val day: Int,
    val state: DayType
)

enum class DayType {
    START, END
}