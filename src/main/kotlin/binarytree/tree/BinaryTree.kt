package binarytree.tree

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null

    fun printTree() {
        printTree(this)
    }
    private fun printTree(node: BinaryTree) {
        node.left?.let(::printTree)
        print(node.value)
        node.right?.let(::printTree)
    }
}

fun buildTree(): BinaryTree {
    val node7 = BinaryTree(7)
    val node6 = BinaryTree(5)
    val node5 = BinaryTree(3)
    val node4 = BinaryTree(1)
    val node3 = BinaryTree(6).apply {
        left = node6
        right = node7
    }
    val node2 = BinaryTree(2).apply {
        left = node4
        right = node5
    }
    val root = BinaryTree(4).apply {
        left = node2
        right = node3
    }
    return root
}