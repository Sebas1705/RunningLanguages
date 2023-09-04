
/* SIMPLE */
function say_hello(){
    console.log("Hi")
}

/* RETURNED AND INFERENCE */
/**
 * Inference by jsdoc
 * @param {number} x 
 * @param {number} y 
 * @returns {number} sum of x and y
 */
function sum(x,y){
    return x+y
}

/* DEFAULT VALUES */
function say_hi(name="NPC"){
    console.log("Hi "+name)
}

/* SUPERIOR ORDER */
/**
 * 
 * @param {number} x 
 * @param {number} y 
 * @param {function(number,number):number} op 
 * @returns {number}
 */
function do_operation(x,y,op){
    return op(x,y)
}

/* RECURSIVE */
function factorial(x){
    return (x<=1) ? x : x*factorial(x-1)
}

/* INDETERMINATE PARAMETERS */
function sums(x,...numbers){
    total=x
    for(let i of numbers) total+=i
    return total
}
console.log(sums(1,2,2,3,2))

/* CONST FUNCTIONS */
const prints = function(msg){
    console.log(msg)
}

/* LAMBDA FUNCTIONS */
const pow = (x,y) => x**y
const divInt = (x,y) =>{
    const div=x/y
    return Math.floor(div)
} 

/* PROMISE */
const getData = ()=>{
    const data=[
        { name: "t1", id: "ddddddk1" },
        { name: "t3", id: "ddddddk2" },
        { name: "t4", id: "ddddddk5" }
    ]
    return new Promise((resolve,reject)=>{
        if(data.length === 0) reject(new Error('Data is empty'))
        setTimeout(()=>{
            resolve(data)
        },3000)
    })
}

// getData()
//     .then((response)=>console.log(response))
//     .catch((err)=>console.log("Error: "+err.message))


/* ASYNC-AWAIT */
async function fetchingData(){
    const books = await getData()
    console.log(books)
}
fetchingData()
