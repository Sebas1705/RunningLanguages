
//Class\\
class Person(val name:String,var age:Int,private val type: String){
    private var tag: String = ""

    init {
        tag = "$name¬$age¬$type"
    }

    constructor(name:String,age:Int) : this(name,age,"default"){
        tag = "$name¬$age¬$type"
    }

    fun hello() = println("Hello $tag!")
}

//Interface\\
interface Talker{
    fun talk(message:String)
}

//Implementation
class Dog : Talker{
    override fun talk(message:String){
        println("Woof! $message")
    }
}

//Abstract class\\
abstract class Shape(val name:String){
    fun sayName() = println("Name: $name")
    abstract fun area() : Double
}

class Circle(name: String, val radius: Double) : Shape(name){
    override fun area() = Math.PI * radius * radius
}


fun main() {
    val p = Person("Pedro",22,"Introvertive")
    p.hello()
    val t : Talker = Dog()
    t.talk("message")
    val s : Shape = Circle("MyCircle",4.2)
    println(s.area())
}