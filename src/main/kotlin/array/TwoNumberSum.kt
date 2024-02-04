package array

fun main() {
    val array = mutableListOf(10, 2, -1, 3, 99, 13)
    val targetSum = 102
    print(twoNumberSum(array, targetSum))
}

// O(N) time | O(N) Space
fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val visitedNums = mutableSetOf<Int>()

    array.forEach { y ->
        val x = targetSum - y // x + y = target
        if (visitedNums.contains(x)) {
            return listOf(x, y)
        } else {
            visitedNums.add(y)
        }
    }
    // Write your code here.
    return listOf()
}