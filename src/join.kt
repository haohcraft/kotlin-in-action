@file:JvmName("StringFunctions")

package strings

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

/**
 * receiver type: "String"
 * receiver object: "this"
 */
//fun String.lastChar() = this.get(this.length - 1)
val String.lastChar: Char
    get() {
        return this.get(this.length - 1)
    }

/**
 * This will only work on a collection of string
 */
fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)
