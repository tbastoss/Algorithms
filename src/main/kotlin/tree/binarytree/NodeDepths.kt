package tree.binarytree

import tree.model.BinaryTree
import tree.model.buildTree

fun main() {
    val tree = buildTree()
    println(nodeDepths(tree))
}

/**
 * On average, it is O(n) Time and O(h) Space, where n is the number of nodes in the
 * binary tree and h is the height of the binary tree
 */
fun nodeDepths(root: BinaryTree): Int {
    return sumOfDepths(root, 0)
}

private fun sumOfDepths(node: BinaryTree?, depth: Int): Int {
    if (node == null) return 0
    return depth + sumOfDepths(node.left, depth+1) + sumOfDepths(node.right, depth+1)
}