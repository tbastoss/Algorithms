package general

import java.util.*

//    Input =   [4, 5, 6, 5, 4, 3]
//    Output =  [3, 6, 4, 4, 5, 5] -> 3 and 6 (appears 1) 4 and 5 (appears 2)
fun main() {
    val test = arrayOf(4, 5, 6, 5, 4, 3)
    sortArrayByAppearanceOfElements(test).forEach {
        print("$it, ")
    }
}

fun sortArrayByAppearanceOfElements(array: Array<Int>): Array<Int> {
    val map = hashMapOf<Int, Int>()
    array.forEach { el ->
        map[el]?.let { count ->
            map[el] = count + 1
        } ?: run {
            map[el] = 1
        }
    }
    println(map)

    val comparator = Comparator<Map.Entry<Int, Int>> { o1, o2 ->
        if (o1.value == o2.value) 0
        else if (o1.value < o2.value) -1
        else 1
    }
    val pq = PriorityQueue(comparator)
    map.forEach { pq.add(it) }
    println(pq)


    val result = mutableListOf<Int>()
    pq.groupBy { it.value }.entries.forEach { entry ->
        for (i in 0 ..< entry.key) {
            entry.value.forEach {
                result.add(it.key)
            }
        }
    }
    println(result)
    return arrayOf()
}