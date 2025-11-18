package net.iessochoa.diegovalencia.repositorioexamenmovil.otros

// Basic Kotlin features summarized in one code block

// --- Variables ---
/*
val immutableValue = 42
var mutableValue = "Hello"

// --- Functions ---
fun greet(name: String): String {
    return "Hi, $name!"
}

// --- Data Class ---
data class User(val id: Int, val name: String)

// --- Lists ---
val immutableList = listOf("Apple", "Banana", "Cherry")
val mutableList = mutableListOf(1, 2, 3)
val arrayList = arrayListOf("Kotlin", "Java", "C++")

// --- Adding / Removing elements ---
mutableList.add(4)
mutableList.remove(2)
arrayList.add("Python")

// --- Iterating over lists ---
for (item in immutableList) {
    println(item)
}

immutableList.forEach {
    println("Item: $it")
}

for (i in mutableList.indices) {
    println("Index $i -> ${mutableList[i]}")
}

// --- Conditional structures ---
val number = 10
if (number > 5) {
    println("Greater than 5")
} else {
    println("5 or less")
}

// --- When (switch-like) ---
when (number) {
    1 -> println("One")
    2, 3 -> println("Two or Three")
    in 4..10 -> println("Between 4 and 10")
    else -> println("Something else")
}

// --- Loops ---
for (i in 1..5) println("Range: $i")
for (i in 0 until 5) println("Until: $i")
for (i in 10 downTo 1 step 2) println("Down: $i")

var counter = 0
while (counter < 3) {
    println("While loop: $counter")
    counter++
}

// --- Null safety ---
var nullableText: String? = null
println(nullableText?.length)       // Safe call
println(nullableText ?: "No text")  // Elvis operator

// --- Classes ---
open class Animal {
    open fun sound() = "Some sound"
}

class Dog : Animal() {
    override fun sound() = "Woof!"
}

// --- Using objects ---
val user = User(1, "Alice")
println(user)
println(Dog().sound())

// --- Type inference & smart casting ---
fun describe(obj: Any) {
    if (obj is String) {
        println("Length: ${obj.length}") // smart cast
    } else if (obj is Int) {
        println("Squared: ${obj * obj}")
    }
}

// --- Sealed class hierarchy ---
sealed class Shape
data class Circle(val radius: Double) : Shape()
data class Rectangle(val w: Double, val h: Double) : Shape()
object Unknown : Shape()

fun area(shape: Shape): Double = when (shape) {
    is Circle -> Math.PI * shape.radius * shape.radius
    is Rectangle -> shape.w * shape.h
    Unknown -> 0.0
}

// --- Map & Set structures ---
val demoMap = mapOf("A" to 1, "B" to 2)
val mutableMap = mutableMapOf("X" to 10)
mutableMap["Y"] = 20

val demoSet = setOf(1, 2, 3)
val mutableSet = mutableSetOf("Red", "Green")
mutableSet.add("Blue")

// --- Iterating Maps & Sets ---
for ((key, value) in demoMap) {
    println("$key -> $value")
}

demoSet.forEachIndexed { index, value ->
    println("Set[$index] = $value")
}

// --- Pair & Triple ---
val pair = Pair("Alice", 25)
val triple = Triple("Bob", "Developer", 5000)

// --- Extensions ---
fun String.shout(): String = this.uppercase() + "!"
println("hello".shout())

// --- Enum class ---
enum class Direction { NORTH, SOUTH, EAST, WEST }

fun move(dir: Direction) {
    when (dir) {
        Direction.NORTH -> println("Going up")
        Direction.SOUTH -> println("Going down")
        Direction.EAST  -> println("Going right")
        Direction.WEST  -> println("Going left")
    }
}

// --- Object declaration (Singleton) ---
object Config {
    val version = "1.0"
    fun info() = "System running version $version"
}

// --- Generics ---
class Box<T>(val item: T) {
    fun get(): T = item
}

val intBox = Box(123)
val stringBox = Box("Hi!")

// --- Inline functions & lambda usage ---
inline fun applyTwice(action: () -> Unit) {
    action()
    action()
}

applyTwice { println("Running...") }

// --- Ranges & progressions ---
for (c in 'a'..'f') println(c)
for (n in 20 downTo 0 step 5) println(n)

// --- Destructuring ---
data class Point(val x: Int, val y: Int)
val (px, py) = Point(10, 20)
println("X=$px, Y=$py")

// --- Exception handling ---
try {
    val risky = 10 / 0
} catch (e: Exception) {
    println("Error: ${e.message}")
} finally {
    println("Finished!")
}

*/