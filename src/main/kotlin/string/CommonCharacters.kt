package string

fun commonCharacters(strings: MutableList<String>): List<String> {
    val smallestString = smallestString(strings)
    val potentialCommonCharacters = smallestString.toList().toMutableSet()

    strings.forEach {
        removeNonExistingCharacters(it, potentialCommonCharacters)
    }

    return potentialCommonCharacters.map { it.toString() }.toList()
}

private fun smallestString(strings: MutableList<String>): String {
    var smallestString = strings[0]
    strings.forEach {
        if (it.length < smallestString.length) smallestString = it
    }
    return smallestString
}

private fun removeNonExistingCharacters(string: String, potentialCommonCharacters: MutableSet<Char>) {
    val uniqueStringCharacters = string.toSet()
    potentialCommonCharacters.toList().forEach { character ->
        potentialCommonCharacters.removeIf { !uniqueStringCharacters.contains(it) }
    }
}