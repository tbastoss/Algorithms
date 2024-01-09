package tree.bst

// Do not edit the class below except for
// the insert, contains, and remove methods.
// Feel free to add new properties and methods
// to the class.
// TODO("in progress")
class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int): BST {
        val newNode = BST(value)
        var currentNode = this
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = newNode
                    break
                } else {
                    currentNode = currentNode.left!!
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode
                    break
                } else {
                    currentNode = currentNode.right!!
                }
            }
        }
        return this
    }

    fun contains(value: Int): Boolean {
        var currentNode: BST? = this
        while (currentNode != null) {
            when {
                value == currentNode.value -> return true
                value < currentNode.value -> currentNode = currentNode.left
                else -> currentNode = currentNode.right
            }
        }
        return false
    }

//    fun remove(value: Int): BST {
//        if (!contains(value)) return this
//        var currentNode = this
//
//        return this
//    }
//
//    private fun removeLeaf(node: BST): BST {
//        if (node.value)
//        return this
//    }
//
//    private fun farLeft(node: BST): BST {
//        var current = node
//        while (true) {
//            if (current.left != null) current = current.left!! else break
//        }
//        return current
//    }
}
