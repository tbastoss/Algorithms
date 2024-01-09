package binarytree

import binarytree.tree.BinaryTree
import binarytree.tree.buildTree

fun nodeDepths(root: BinaryTree): Int {
    return sumOfDepths(root, 0)
}

private fun sumOfDepths(node: BinaryTree?, depth: Int): Int {
    if (node == null) return 0
    return depth + sumOfDepths(node.left, depth+1) + sumOfDepths(node.right, depth+1)
}

fun main() {
    val tree = buildTree()
    println(nodeDepths(tree))
}