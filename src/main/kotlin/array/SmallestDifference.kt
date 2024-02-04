package array


/**
 * Algorithm:
 *
 * Sort array A and B
 * Create minDif equals to max integer
 * Create result as a mutableList of 2 items
 * Set i and j at the beginning of A and B respectively
 *
 * while (minDif != 0 && i < A.size && j < B.size) do :
 * currentDif = |A[i] - B[j]|
 * if (currentDif < minDif) do
 * minDif = currentDif
 * result[0] = A[I]
 * result[1] = A[j]
 * endIf
 * if (A[i] < B[j]) increase i with 1 else increase j with 1
 * endWhile
 * return result
 */

fun main() {
    val arrayOne = mutableListOf(-1, 3, 5, 10, 20, 28)
    val arrayTwo = mutableListOf(15, 17, 26, 134, 135)
    val result = smallestDifference(arrayOne, arrayTwo)

    println(result.toString())
}

/**
 * This is an (n log(n) + m log(m)) for Time since we need to sort the array and sorting algorithm is n log(n).
 * Also, it is used m and n since arrays have different sizes.
 * For Space complexity it is O(1) since space usage doesn't increase when input size increases. It is always
 * an array of size 2.
 */
fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    var minDif = Integer.MAX_VALUE
    var i = 0
    var j = 0
    // Sort arrays
    arrayOne.sort()
    arrayTwo.sort()
    val result = mutableListOf(arrayOne[0], arrayTwo[0])

    while (minDif != 0 && i < arrayOne.size && j < arrayTwo.size) {
        val currentDiff = Math.abs(arrayOne[i] - arrayTwo[j])
        if (currentDiff < minDif) {
            minDif = currentDiff
            result[0] = arrayOne[i]
            result[1] = arrayTwo[j]
        }
        if (arrayOne[i] < arrayTwo[j]) i++ else j++
    }
    return result
}