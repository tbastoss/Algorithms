package array

fun main() {
    val array = mutableListOf(10, 2, -1, 3, 99, 13) // [-1, 2, 3, 10, 13, 99]
    val targetSum = 4
    print(threeNumberSum(array, targetSum))
}

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    array.sort()
    val triplets = mutableListOf<List<Int>>()
    for (i in 0.. array.size - 3) {
        var left = i + 1
        var right = array.size - 1
        while (left < right) {
            val currentSum = array[i] + array[left] + array[right]
            if (currentSum == targetSum) {
                val triplet = mutableListOf(array[i], array[left], array[right])
                triplets.add(triplet)
                left++
                right--
            } else if (currentSum < targetSum) {
                left++
            } else {
                right--
            }
        }
    }
    return triplets
}