package general

fun main() {
    fibonacci(4).forEach { print("$it, ") }
    fibonacciRep(4).forEach { print("$it, ") }
}

/**
 * This is a O(n) for T and S since it will have to execute N times the logic inside the for loop
 * and the the returned array will have the size N which means it will increase as much as N increases.
 */
fun fibonacci(n: Int): Array<Int> {
    if (n < 1) return arrayOf()
    if (n == 1) return arrayOf(0)
    if (n == 2) return arrayOf(0, 1)
    val sequence = mutableListOf(0, 1)
    for (i in 2 ..< n) {
        val nextValue = sequence[i-2] + sequence[i-1]
        sequence.add(nextValue)
    }
    return sequence.toTypedArray()
}

fun fibonacciRep(n: Int): Array<Int> {
    val result = mutableListOf<Int>()
    for (i in 1 .. n) result.add(calcElementRec(i))
    return result.toTypedArray()
}

private fun calcElementRec(n: Int): Int {
    if (n == 1) return 0
    if (n == 2) return 1
    return calcElementRec(n-2) + calcElementRec(n-1)
}