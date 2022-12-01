package leetcode.q1306

import java.util.*

// https://leetcode.com/problems/jump-game-iii/
class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val size = arr.size;
        // list 선언과 동시에 초기화 하는법 (사이즈, 초기값)
        val isVisits = MutableList(size) {false}
        var canReach = false

        val bfsQueue: Queue<Int> = LinkedList()
        bfsQueue.offer(start)

        while (!bfsQueue.isEmpty()) {
            val currentIndex = bfsQueue.poll()
            val current = arr[currentIndex]
            isVisits[currentIndex] = true

            if (current == 0) {
                canReach = true
                break
            }

            val currentLeft = currentIndex - current
            if (currentLeft >= 0 && !isVisits[currentLeft]) bfsQueue.offer(currentLeft)

            val currentRight = currentIndex + current
            if (currentRight < size && !isVisits[currentRight]) bfsQueue.offer(currentRight)
        }

        return canReach
    }
}