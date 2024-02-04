package general

//    Input =   [4, 5, 6, 5, 4, 3]
//    Output =  [3, 6, 4, 4, 5, 5] -> 3 and 6 (appears 1) 4 and 5 (appears 2)
fun main() {
    val test = arrayOf(4, 5, 6, 5, 4, 3)
    val test1 = arrayOf(1, 2, 3, 4, 5)
    val result = sortArrayByAppearanceOfElements(test)

    print("[")
    result.forEachIndexed { index, element ->
        if (result.lastIndex == index) print("$element") else print("$element, ")
    }
    println("]")
}

fun sortArrayByAppearanceOfElements(array: Array<Int>): Array<Int> {
    println(array.toList().toString())
    val elementToCountMap = hashMapOf<Int, Int>()
    array.forEach { el ->
        elementToCountMap[el]?.let { count ->
            elementToCountMap[el] = count + 1
        } ?: run {
            elementToCountMap[el] = 1
        }
    }
    println(elementToCountMap)

    val countToListOfElementsMap = hashMapOf<Int, MutableList<Int>>()
    array.forEach { element ->
        val elementCount = elementToCountMap[element]!!
        countToListOfElementsMap[elementCount]?.add(element) ?: countToListOfElementsMap.put(elementCount, mutableListOf(element))
    }
    println(countToListOfElementsMap)

    val result = mutableListOf<Int>()
    for (possibleRep in array.indices) {
        countToListOfElementsMap[possibleRep]?.let {
            it.sort()
            result.addAll(it)
        }
    }
    println(result)

    return result.toTypedArray()
}