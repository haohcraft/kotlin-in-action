/**
 * Chapter 6: the Kotlin type system
 * - nullable types
 * - ready-only collections
 *
 */

/**
 * 6.1.1 Nullable types
 * Type? = Type or null
 * A type is a classification...that determines the possible values for that type, and the operations that
 * can be done on values of that type.
 */

/**
 * 6.1.3 Safe call operator: "?."
 * foo?.bar()
 *  - if foo != null -> foo.bar()
 *  - if foo == null -> null
 */

/**
 * 6.1.4 Elvis operator: "?."
 */

// If "s" is null, the result is an empty string
fun foo(s: String?) {
    val t: String = s ?: ""
}


/**
 * 6.1.5 Safe casts: "as?"
 * foo as? Type
 * - if foo is Type, foo as Type
 * - if foo !is Type, null
 */

/**
 * 6.1.6. Not-null assertions: “!!”
 * foo!!
 * - foo != null, foo
 * - foo == null, NullPointerException
 */

/**
 * 6.1.7. The “let” function
 * foo?.let {..it..}
 * - if foo != null, it is non-null inside lambda
 * - if foo == null, nothing happens
 */

/**
 * 6.1.8. Late-initialized properties
 *
 * 6.2.1. Primitive types: Int, Boolean, and more
 * in JAVA
 * - primitive type holds its value directly
 * - reference type holds a reference to the memory location containing the obj
 *
 * Any is a non-nullable type, so a variable of the type Any can’t hold the value null.
 *
 * all Kotlin classes have the following three methods: toString, equals, and hashCode.
 *
 * Unit is a full-fledged type, and, unlike void, it can be used as a type argument.
 * Only one value of this type exists; it’s also called Unit and is returned implicitly
 *
 *
 * 6.2.6. The Nothing type: “This function never returns”
 * - The compiler knows that a function with this return type never terminates normally
 * and uses that information when analyzing the code calling the function
 */

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

/**
 * 6.3. COLLECTIONS AND ARRAYS
 *
 */
