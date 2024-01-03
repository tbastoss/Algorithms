package org.example.array

/**
 * Given an array of integers between of 1 ... n, where n is the length of the array,
 * write a function that returns the first integer that appears more than once (when array
 * is read left to right).
 *
 * If no integer appears more than once, o yur function should return -1
 *
 * Example:
 * A = [2,1,5,2,3,3,4] -> return 2
 * B = [2,1,5,3,3,2,4] -> return 3
 */

fun main() {
    val input = mutableListOf(2, 1, 5, 2, 3, 3, 4)
    println(firstDuplicateValue2(input))
}

/**
 * This solution is O(n) for space and time
 * 1) Use a Set to save the visited element (worst case it will have to create a Set with same length as the array,
 *    that's why it is O(n) for space);
 *
 * 2) Even thought the algorithm is consulting the Set for each one of the elements in the array,
 *    it is an O(1) T operation;
 *
 * 3) It is O(n) T since it will be necessary to run through the array at least once
 */
fun firstDuplicateValue1(array: MutableList<Int>): Int {
    val countSet = mutableSetOf<Int>()

    array.forEach { el ->
        if (countSet.contains(el)) {
            return el
        } else {
            countSet.add(el)
        }
    }

    return -1
}


/**
 * This solution is O(n) T and O(1) S
 * 1) it won't create another structure to store the visited elements, it will use the array itself to do by
 *    by turning the visited element into negative. That's how it can be done in O(1) S;
 *
 * 2) it is still O(n) T since it will be necessary to run through the array at least once.
 */
fun firstDuplicateValue2(array: MutableList<Int>): Int {
    array.forEach { el ->
        val index = Math.abs(el) - 1
        if (array[index] < 0) {
            return Math.abs(el)
        } else {
            array[index] = array[index] * -1
        }
    }
    return -1
}