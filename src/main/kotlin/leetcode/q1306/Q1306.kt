package leetcode.q1306

import java.util.*

// https://leetcode.com/problems/jump-game-iii/
class Solution {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val size = arr.size;
        // list 선언과 동시에 초기화 하는법 (사이즈, 초기값)
        val isVisits = MutableList(size) {false}

        val bfsQueue: Queue<Int> = LinkedList()
        bfsQueue.offer(start)

        while (!bfsQueue.isEmpty()) {
            val currentIndex = bfsQueue.poll()
            val current = arr[currentIndex]
            isVisits[currentIndex] = true

            if (current == 0) return true

            this.visitIfPossible(bfsQueue, isVisits, currentIndex - current, size)
            this.visitIfPossible(bfsQueue, isVisits, currentIndex + current, size)
        }

        return false
    }

    private fun visitIfPossible(bfsQueue: Queue<Int>, isVisits: MutableList<Boolean>, next: Int, size: Int) {
        if (next in 0 until size && !isVisits[next]) bfsQueue.offer(next)
    }
}