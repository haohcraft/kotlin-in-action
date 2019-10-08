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

fun TalkativeButton.giveSpeech() {
    yell()
    whisper()
}

/**
 * 4.1.4 inner and nested classes: nested by default
 * KT nested classes don't have access to the outer class instance
 */


class Button: Clickable {
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
