package binarytree

import binarytree.tree.BinaryTree
import binarytree.tree.buildTree

/**
 * Time: O(N)
 * Space: O(log(N)) -> it is log(N) because it will execute all call to the left, and only after it is done with
 * left branch (rec stack is empty again) it will go to the right items. which means that the space it will occupy
 * will be the depth of the tree which is log(n) for a BinaryTree.
 */
fun invertBinaryTreeRec(tree: BinaryTree) {
    tree.swapChildren()
    tree.left?.let(::invertBinaryTreeRec)
    tree.right?.let(::invertBinaryTreeRec)
}

/**
 * Time: O(N)
 * Space: O(N) -> this is O(N) because it is necessary to create a auxiliary data structure (Queue) which is the worst
 * case can get as big as the tree (have as many elements as the tree).
 */
fun invertBinaryTree(tree: BinaryTree) {
    val queue = mutableListOf<BinaryTree?>(tree)
    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0) ?: continue
        current.swapChildren()
        queue.add(current.left)
        queue.add(current.right)
    }
}

private fun BinaryTree.swapChildren() {
    val aux = right
    right = left
    left = aux
}

fun  main() {
    val tree = buildTree()
    tree.printTree()
    invertBinaryTree(tree)
    println()
    tree.printTree()
}