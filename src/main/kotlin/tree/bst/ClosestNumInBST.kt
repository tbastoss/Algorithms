package tree.bst

import tree.model.BinaryTree
import tree.model.buildTree

fun findClosestValueInBst(tree: BinaryTree, target: Int): Int {
    var currentNode: BinaryTree? = tree
    var closest = Integer.MAX_VALUE
    while (currentNode != null) {
        if (isCurrentValueTheClosest(target, closest, currentNode.value)) {
            closest = currentNode.value
        } else if (target < currentNode.value) {
            currentNode = currentNode.left
        } else if (target > currentNode.value) {
            currentNode = currentNode.right
        } else {
            break
        }
    }
    return closest
}

private fun isCurrentValueTheClosest(target: Int, closest: Int, currentValue: Int): Boolean {
    return (Math.abs(target - closest)) > (Math.abs(target - currentValue))
}

fun main() {
    val tree = buildTree()
    val target = 10
    val result = findClosestValueInBst(tree, target)
    print("tree = ")
    tree.printTree()
    println()
    println("closestTo=$target is $result")
}
