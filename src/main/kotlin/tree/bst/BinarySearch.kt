package tree.bst

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val list2 = listOf("a", "b", "c", "d")
    println("index: ${biSearch(list, 6)}")
    println("index: ${biSearch(list2, "b")}")
}

fun biSearch(list: List<Int>, el: Int): Int {
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

fun biSearch(list: List<String>, el: String): Int {
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