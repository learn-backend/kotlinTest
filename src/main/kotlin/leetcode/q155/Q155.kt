package leetcode.q155

import java.util.*

// https://leetcode.com/problems/min-stack/
class Q155 {
    val inputStack = Stack<Int>()
    val minStack = Stack<Int>()

    fun push(`val`: Int) {
        inputStack.push(`val`)
        if(minStack.isEmpty() || `val` <= minStack.peek() ) minStack.push(`val`)
    }

    fun pop() {
        if(minStack.peek() == inputStack.peek()) {
            minStack.pop()
        }
        inputStack.pop()
    }

    fun top(): Int {
        return inputStack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}

