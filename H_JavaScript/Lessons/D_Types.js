
//Variable types:
var config_length = 300 //Global scope
let name = "sebas" //Local scope
const PI = 3.141592653589793 //Constant

//let n=10,d=10.20,e=10.20e-10 //multiple variable initialization

/* PRIMITIVES */

//Number:
let n = 10 
let d = 10.20 
let e = 10.20e-10 
console.log(n,d,e)

//String:
const type = "PRESSURE"
const message = 'Hello, world'
console.log(type+' || '+message)

//Boolean:
const t = true, f = false
console.log(t,f)

//Undefined:
let undef
console.log(undef)

//Null:
let nulled = null
console.log(nulled)

//Symbol:
const symbol = Symbol('description')
console.log(symbol)

//BigInt:
const bigNumber = 1234567890123456789012345678901234567890n
console.log(bigNumber)

//Not a number:
const nan = NaN
console.log(nan)

//Object:
const person = {
    name : "Alberto",
    age : 21
}
console.log(person)
console.log(person.name)

//Array:
const array = [1,2,"Bob",true]
console.log(array)
console.log(array[1])


/* OPERATORS */

//ARITHMETICS:
console.log(5 + 3)  //Sum
console.log(10 - 4) //Sub
console.log(3 * 6)  //Mult
console.log(12 / 4) //Div
console.log(17 % 5) //Mod
console.log(17**4)  //Pow
console.log(17<<4)  //Lshift
console.log(12>>4)  //Rshift
console.log(12>>>4) //Rshift unsigned
console.log(12 & 4) //And bit
console.log(12 | 4) //Or bit
console.log(13 ^ 4) //Xor bit
console.log(nulled ?? 12) //logic null

//ASSIGNATION:
let x = 10  //assignment
let y = 5
y += 3      //update (operator plus = , *=, -=, ...)

//COMPARISON:
const a = 5
const b = "5"
console.log(a == b)     // Equal
console.log(a === b)    // Strict equal
console.log(a != b)     // Not equal
console.log(a !== b)    // Not strict equal
const c = 10
console.log(c > a)  // Greater than
console.log(c < a)  // Less than
console.log(c >= a) // Greater or equal
console.log(c <= a) // Less or equal

//LOGICS:
console.log(t && t) // And
console.log(f || t) // Or
console.log(!f)     // Not

//CONCAT:
console.log("Hello"+", "+"world!")

//TERNARY:
const age = 18
const adult = age >= 18 ? "Yes" : "Not yet"

//INCREMENT AND DECREMENT:
let cont = 5
console.log(++cont) //Preincrement
console.log(cont++) //Postincrement
console.log(--cont) //Predecrement
console.log(cont--) //Postdecrement

//FORMATTER:
console.log("Hello world!")
console.log(`${cont} ${age}`)
