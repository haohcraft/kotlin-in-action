fun main() {
    println(
        """
            Chapter 4: Classes, objects, and interfaces
        """.trimIndent()
    )
    // 4.1 defining class hierarchies
    // 4.1.1 interfaces
    // Note:
    // - can implement many interfaces, but can extend only one class
    val button = Button()
    button.click()



}
/**
 * 4.1.2 Open, final, and abstract
 * - final by default
 *
 */
open class RichButton : Clickable {
    fun disable() {} // this is final: you can't override it in a subclass
    open fun animate() {}
    override fun click() {} // this fun overrides an open fun and is open as well
}

/**
 * - a member in an interface is always open; can't declare it as final
 * - abstract class
 */
abstract class Animated {  // this class is abstract: you can't create an instance of it
    abstract fun animate() // this fun is abstract and has no implementation, and must be overridden in subclass
    open fun stopAnimating() {} // non-abstract functions in abstract classes aren't open by default
    fun animateTwice() {}
}

/**
 * 4.1.3 visibility modifiers: public by default
 *  - public, protected and private
 *  - kotlin does not use packages for visibility control
 *  - instead, "internal", which means visible inside a module (a module is a set of Kt files complied together)
 *  - in kotlin: "private" is visible only in the file where they declared
 */
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey")
    protected fun whisper() = println("let's talk")
}

//


/**
 * 4.1.4 inner and nested classes: nested by default
 * KT nested classes don't have access to the outer class instance
 */

/**
 * 4.1.5 sealed classes: defining restricted class hierarchies
 */

sealed class Expr {
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
    when (e) { // the "when" expression covers all possible cases, so no "else" branch is needed
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }

/**
 * 4.2 declaring a class with nontrivial constructors or properties
 */

// 4.2.1 primary constructor and initializer blocks
// If your class has a superclass, the primary constructor also needs to initialize the superclass.
open class User(val username: String) // primary constructor; "val" means the property will be initialized with "username"
class TwitterUser(nickname: String) : User(nickname)

// the default constructor without arguments is generated
// note: interfaces don't have constructors
class RadioButton: Button()

/** 4.2.2 secondary constructors **/
// If the class has no primary constructor, then each secondary constructor has to initialize the base class or delegate to another constructor that does so.

/*

class User constructor(_username: String) {
    val nickname: String
    init {
        username = _username
    }
}
 */

/** 4.2.3 Implementing properties declared in interfaces **/
interface UserInterface {
    val nickname: String
}

class PrivateUser(override val nickname: String) : UserInterface
class SubscribingUser(val email: String): UserInterface {
    override val nickname: String
        get() = email.substringBefore("@")
}
class FacebookUser(val accountId: Int): UserInterface {
    override val nickname: String = getFbName(accountId)

    private fun getFbName(accountId: Int): String = "name_collection"[accountId].toString()

}

/** 4.2.4 Accessing a backing field from a getter or setter**/
// the special identifier "field" to access the value of the backing field

/** 4.3 compiler-generated methods: data classes and class delegation **/
/** 4.3.1 Universal Object methods **/
data class Client(val username: String, val postalCode: Int)
// it will compile to JAVA class containing equals, hashCode , and toString

/** 4.3.2 class delegation: using the "by" keywords **/
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

/**
 *  4.4 Object keyword
 *  - to define a singleton
 *  - companion object
 *  - object expression
 *
 * **/

/** 4.4.1 Object declarations: singleton made easy **/
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        TODO("")
    }

}

/** 4.4.2 companion objects: a place for factory methods and static members **/
/** 4.4.4. Object expressions: anonymous inner classes rephrased **/



open class Button: Clickable {
    override fun click() {
        println("i was clicked")
    }
}

interface Clickable {
    fun click()
    fun showoff() = println("I am clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}
