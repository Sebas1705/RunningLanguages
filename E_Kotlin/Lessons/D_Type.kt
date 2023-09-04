
fun main() {
    
    // Integers:
        var b: Byte = 12; //1B | -128 to 127 
        var s: Short = 222; //2B | -32768 to 32767
        var i: Int = 199; //4B | -2147483648 to 2147483647
        var l: Long = 192929; //8B | -9223372036854775808 to 9223372036854775807

        println(b+s+i+l)
    // End Integers.

    // Floats:
        var f: Float = 1.292f; //4B | ±1.4E-45 to ±3.4E38
        var d: Double = 282.282828E82; //8B | ±4.9E324 a ±1.8E308

        println(f+d)
    // End Floats.

    // Others:
        var c: Char = 'a'; //1 character unicode (2B) | U+0000 to U+FFFF
        var bl: Boolean = true; //1 bit | true or false
        var str: String = "Hola"; //2B per character
        //var u: Unit  //similar to void
        //var n: Nothing //no value

        println(c+"$bl"+str)
    // End Others.

    // Operands:

    var x:Int = 5
    var y:Int = 2
    // Arimethics:
        println(x+y);//Sum
        println(x-y);//Subtract
        println(x*y);//Multiply
        println(x/y);//Division
        println(x%y);//Mod
    // End Aritmethics.

    var m = true
    var n = false

    // Logics:
        println(m==n);//Equal
        println(m!=n);//Not equal
        println(x>y);//Greater
        println(x>=b);//Greater or equal
        println(x<y);//Minor
        println(x<=y);//Minor or equal
        println(m&&n);//AND
        println(m||n);//OR
        println(!m);//NOT
    // End Logics.

    var cad1 ="Hola "
    var cad2 = "Mundo ";
    var ss = '!';

    // Compound:
        x += 7; //Compress operation (with all arithmetic and logic operands)
        System.out.println(cad1+cad2+"$x"+ss);//Concat
        var range = 1..5
        println(range)
        var rangeU = 1 until 10
        println(rangeU)
        var strOrNull : String? = null; //with ? can be null
        var strDec = strOrNull ?: "Null"
        println(strDec)
        var length = strOrNull?.length ?: -1
        println(length)
        //var len = strOrNull!!.length //if its null throw NullPointerException
    // End Compound.

    // Const:
        val r = 10
        //r = 10 //Can't do this
        println(r)
    // End Const.

    // Arrays:
        val numbers: Array<Int> = Array(5) { i -> i + 1 } //Generate with lambda
        println(numbers)
        val colors = arrayOf("Red","Green","Yellow") //Generate with recolectors
        println(colors)
        val integers = intArrayOf(1,23,4,3,2,2) //Special recolectors
        println(integers)
        val doubles = doubleArrayOf(1.2,2.22,34.3) //Other special recolectors
        println(doubles)
        val arrayOfArrays = arrayOf(arrayOf(1,2,3),arrayOf(1,2,4))
        println(arrayOfArrays)
        val array2D : Array<Array<Int>> = Array(5) { row -> Array(5) { col -> row*col } }
        println(array2D[1][2])
    // End Arrays.
}