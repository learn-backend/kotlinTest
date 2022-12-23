package leetcode.q653

import java.util.*


// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
// BFS 풀이
fun main() {
    var root = TreeNode.makeTreeNode(listOf(5,3,6,2,4,null,7))
//    println(root)
    var result = findTarget(root, 28)
    println(result)
}
fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set = HashSet<Int>()
    val queue : Queue<TreeNode> = LinkedList()
    queue.add(root)
    while (queue.isNotEmpty())
    {
        val current = queue.poll()
        val currentVal = current.`val`
        if(set.contains(k - currentVal))
            return true
        else
            set.add(currentVal)

        current?.left?.let { queue.offer(it) }
        current?.right?.let { queue.offer(it) }

    }
    return false
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun makeTreeNode(values: List<Int?>): TreeNode? {
            return if (values.isEmpty()) {
                null
            } else {
                val queue = LinkedList<TreeNode>()
                val root = TreeNode(values.first()!!)
                queue.add(root)
                IntProgression.fromClosedRange(1, values.lastIndex - 1, 2).forEach {
                    val parent = queue.pop()
                    values[it]?.let { value -> TreeNode(value) }?.also { treeNode -> parent.left = treeNode }?.also { treeNode -> queue.add(treeNode) }
                    values[it + 1]?.let { value -> TreeNode(value) }?.also { treeNode -> parent.right = treeNode }?.also { treeNode -> queue.add(treeNode) }
                }
                if (values.size % 2 == 0 && values.last() != null) {
                    val parent = queue.pop()
                    parent.left = TreeNode(values.last()!!)
                }
                root
            }
        }
    }

    override fun toString(): String {
        return "${this.`val`} ${this.left?.toString() ?: ""} ${this.right?.toString() ?: ""}"
    }
}