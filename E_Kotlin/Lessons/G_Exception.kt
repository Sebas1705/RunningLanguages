
fun div(a:Int, b:Int):Int{
    if(b==0) throw IllegalArgumentException("Divisor cannot be 0")
    return a / b
}

fun main() {
    
    try{
        div(2,0)
        println("No should execute")
    }catch(e: IllegalArgumentException){
        println("Error: ${e.message}")
    }finally{
        println("Always executed")
    }
}