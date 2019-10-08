import strings.joinToString
import strings.lastChar

fun main(args: Array<String>) {
    val list = listOf<Int>(1, 2, 3, 4)
    println(joinToString(collection = list, separator = "; ", prefix = "(", postfix = ")"))
    println(joinToString(collection = list))
    // 3.3.4 extension functions
    // - Under the hood, an extension function is a static method that accepts the receiver object as its first argument.
    // Calling it doesn’t involve creating adapter objects or any other runtime overhead.
    println("Kotlin".lastChar)

    // 3.3.5 Extension properties

    // 3.4 working with collections
    // 3.4.1 Extending JAVA Collection API
    val strings: List<String> = listOf("fisrt", "secondd", "fourteenth")
    println(strings.last())

    // 3.4.3 varargs
    val list2 = listOf("args: ", args)
    println(list2)

    // 3.4.3 working with paris
    // "infix" call
    val map = mapOf(1 to "one", 7 to "seven")

    // 3.5 strings and regx
    // 3.5.1 splitting strings
    // 3.5.2 regx and triple-quoted strings


}

