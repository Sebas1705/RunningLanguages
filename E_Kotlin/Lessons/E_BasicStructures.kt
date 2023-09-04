
fun main() {
    
    //If\\
    var x : Int = 100

    //Extended:
    if (x<10){
        println("Less than 10")
    }else if (x>10){
        println("Greater than 10")
    }else{
        println("Equal to 10")
    }

    //Compresive:
    var t: Int = if (x!=100) x else x*x
    println(t)

    //Not-null if:
    var s : String? = "string"
    s?.let { println(s) }

    //When\\
    when (s){
        "string" -> println(s.hashCode())
        "Hhhhhh" -> println(s.get(4))
        else -> println("No")
    }

    //While\\
    var y : Int = 10
    while (y!=0){
        y-=1
        if (y==5){
            continue
        }
        println(y)
    }

    //Do-While\\
    do{
        y+=1
        println(y)
        if (y==9) break
    }while(y!=0&&y<10)

    //For\\

    //Close range:
    for(i in 1..5) println(i)
    println("------------------------------")

    //Open range:
    for(i in 1 until 5) println(i)
    println("------------------------------")

    //Range with step:
    for(i in 1..10 step 4) println(i)
    println("------------------------------")

    //Range inverse:
    for(i in 1 downTo -10 step 2) println(i)
    println("------------------------------")

    //Iterable or collection:
    val names = listOf("James","Cruise","Bob")
    for (i in names) println(i)
    println("------------------------------")

    //After with index:
    for ( (idx,i) in names.withIndex()) println("$idx:$i")
    println("------------------------------")

    //Maps:
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((key,value) in map) println("$key:$value")
    println("------------------------------")

    //Chars range:
    for(i in 'a'..'z') println(i)
    println("------------------------------")
}