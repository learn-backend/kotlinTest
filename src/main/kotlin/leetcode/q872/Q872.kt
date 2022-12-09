package leetcode.q872

// https://leetcode.com/problems/leaf-similar-trees/
fun main() {


    Q872.leafSimilar(

        TreeNode.create(
            3,
            TreeNode.create(5, TreeNode(6), TreeNode.create(2, TreeNode(7), TreeNode(4))),
            TreeNode.create(1, TreeNode(9), TreeNode(8))
        ),
        null
    )
}


/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
object Q872 {

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leafs1 = mutableListOf<Int>()
        search(root1, leafs1)

        val leafs2 = mutableListOf<Int>()
        search(root2, leafs2)

        return leafs1 == leafs2
    }

    fun search(root: TreeNode?, leafs: MutableList<Int>) {
        if (root == null) {
            return
        }

        if (root.left == null && root.right == null) {
            leafs.add(root.`val`)
            return
        }

        search(root.left, leafs)
        search(root.right, leafs)
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun create(value: Int, left: TreeNode?, right: TreeNode): TreeNode {
            val treeNode = TreeNode(value)
            treeNode.left = left
            treeNode.right = right
            return treeNode
        }
    }
}

