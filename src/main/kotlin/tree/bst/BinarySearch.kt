package tree.bst

fun main() {
    val listAlgoExpert = listOf(0, 1, 21, 33, 45, 45, 61, 71, 72, 73)
    println(binarySearch(listAlgoExpert, 33))
    val list2 = listOf("a", "b", "c", "d")
    println("index: ${binarySearchString(list2, "b")}")
}

/**
 * This is a O(log(n)) Time and O(1) Space solution, where n is the length of the array.
 */
fun binarySearch(array: List<Int>, target: Int): Int {
    var start = 0
    var end = array.size - 1

    while (start <= end) {
        val mid = start + ((end - start) / 2)
        when {
            target > array[mid] -> start = mid + 1
            target < array[mid] -> end = mid - 1
            target == array[mid] -> return mid
        }
    }

    return -1
}

fun binarySearchString(list: List<String>, el: String): Int {
    var start = 0
    var end = list.size - 1

    while (start <= end) {
        val mid = start + ((end - start) / 2)
        when {
            el > list[mid] -> start = mid + 1
            el < list[mid] -> end = mid - 1
            el == list[mid] -> return mid
        }
    }

    return -1
}