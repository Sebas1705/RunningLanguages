
//Simples:
fun hello(name: String){
    println("Hello $name!")
}

//Returned functions:
fun sum(a:Int,b:Int):Int {
    return a + b
}

//Inference type functions:
fun mult(a:Double,b:Double) = a * b

//Args with names:
fun printPerson(name:String,age:Int) = println("Name: $name, age: $age")

//Predetermined parameters:
fun sayHello(name: String = "NPC") = println("Hello $name")

//Extension functions:
fun String.sayBye() = println("Bye $this!")

//Functions Superiors order:
fun doIt(a:Int,b:Int,func:(Int,Int)->Int) = func(a,b)

//Recursive functions:
fun factorial(n:Int):Int = if (n==0) 1 else n * factorial(n-1)

//Anonimated functions:
val square = fun(x:Int):Int = x*x


fun main() {
    hello("Sebas")
    println(sum(5,34))
    println(mult(34.3,42.22))
    printPerson(age=21,name="Sebas")
    sayHello("Sebas")
    sayHello()
    "Sebas".sayBye()
    println(doIt(24,21){x,y->x+y})
    println(factorial(5))
    println(square(22))
    
}