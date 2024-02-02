package com.org.general

fun main() {
    fibonacci(4).forEach {
        print("$it, ")
    }
}


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