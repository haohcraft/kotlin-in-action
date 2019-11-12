/**
 * Chapter 7, Operator overloading and other conventions
 *
 */


/**
 * 7.1 Overloading arithmetic operators
 * 7.1.1 Overloading binary arithmetic operations
 */
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

fun main() {
    val p1 = Point(10, 20)
    val p2 = Point(30,40)
    println(p1 + p2)

    println('a' * 6)
}

/**
 * 7.1.2. Overloading compound assignment operators
 * 7.2.1. Equality operators: “equals”
 * ==
 * ===, identity equals
 *
 *
 * 7.2.2. Ordering operators: compareTo
 */
