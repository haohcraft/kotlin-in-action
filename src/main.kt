import strings.joinToString

fun main() {
    val list = listOf<Int>(1, 2, 3, 4)
    println(joinToString(collection = list, separator = "; ", prefix = "(", postfix = ")"))
    println(joinToString(collection = list))
}

