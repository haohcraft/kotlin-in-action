fun main() {
    val list = listOf<Int>(1, 2, 3, 4)
    println(joinToString(collection = list, separator = "; ", prefix = "(", postfix = ")"))
    println(joinToString(collection = list))
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)

    }
    result.append(postfix)
    return result.toString()
}
