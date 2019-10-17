import Person
import java.lang.StringBuilder

/**
 * Chapter 5. Programming with lambdas
 * - Lambda expressions and member references
 * - working with collections
 * - sequences
 * - using java interfaces in KT
 * - user lambdas with receivers
 */

/**
 * 5.1 lambda expressions and member references
 */


fun main() {
    println("Chapter 5")
    findMaxAge()
    run { println("42") }
}

fun findMaxAge() {

    val people = listOf<Person>(Person("Alice", 20), Person("Bob", 12))
//    println(people.maxBy { it.age })
    // If a lambda is the only argument, you’ll definitely want to write it without the parentheses.
    println(people.maxBy { p: Person -> p.age })

}

/**
 * 5.1.3 Syntax for lambda expressions
 * {x: Int, y: Int -> x + y}
 */


/**
 * 5.1.4 Accessing variables in scope
 *
 */

/**
 * 5.1.5 Member references
 *
 * val getAge = Person::age
 *
 *
 */

//"constructor reference":
val createPerson = ::Person
val p = createPerson("mike", 22)

// bound references
fun getBoundRef() {
    val sam = Person("sam", 22)
    val personsAgeFunction = Person::age

    println(personsAgeFunction(sam))

    val samAgeFunction = sam::age
    println(samAgeFunction)
}

/**
 * 5.2 functional api for collections
 * filter, map,
 * all, any, count, find: applying a predicate to a collection
 * groupBy
 * flatten, flatMap
 */

/**
 * 5.3 lazy collection operations: sequences
 * As a rule, use a sequence whenever you have a chain of operations on a large collection.
 */
// no intermediate collections to store the elements are created, so performance for a large number of elements will be noticeably better.
//  For sequences, all operations are applied to each element sequentially: the first element is processed (mapped, then filtered), then the second element is processed, and so on.
fun findPeopleWhoseNameStartsA(): List<String> {
    val people = listOf<Person>(Person("alice", 12), Person("bill", 33))
    return people.asSequence()
        .map { it.name }
        .filter { it.startsWith("A") }
        .toList()
}

/**
 * 5.4 using java functional interfaces
 * 5.4.1. Passing a lambda as a parameter to a Java method
 */


/***
 * Lambda implementation details
 *
 * Every lambda expression is compiled into an anonymous class, unless it's an inline lambda.
 */

/**
 * 5.4.2 SAM constructors: explicit conversion of lambdas to functional interfaces
 */

/**
 * 5.5 Lambdas with receivers: with and apply
 */

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabetWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'B') {
            this.append(letter)
        }
        this.append("\nNow I know the alphabet!")
        this.toString()
    }
}

/**
 * A lambda is a way to define behavior similar to a regular function.
 * A lambda with a receiver is a way to define behavior similar to an extension function.
 */
/**
 * 5.5.2 The "Apply" function
 * The apply function is declared as an extension function.
 * Its receiver becomes the receiver of the lambda passed as an argument.
 * The result of executing apply is StringBuilder, so you call toString to convert it to String afterward.
 */
fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'B') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.toString()

