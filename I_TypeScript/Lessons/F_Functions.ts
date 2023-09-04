
/* SIMPLE */
function say_hello():void{
    console.log("Hi")
}

/* RETURNED AND INFERENCE */
function sum(x:number,y:number):number{
    return x+y
}

/* DEFAULT VALUES */
function say_hi(name="NPC"):void{
    console.log("Hi "+name)
}

/* SUPERIOR ORDER */
function do_operation(x:number,y:number,op:(x:number,y:number)=>number):number{
    return op(x,y)
}

/* RECURSIVE */
function factorial(x:number):number{
    return (x<=1) ? x : x*factorial(x-1)
}

/* INDETERMINATE PARAMETERS */
function sums(x:number,...numbers:number[]){
    let total=x
    for(let i of numbers) total+=i
    return total
}
console.log(sums(1,2,2,3,2))

/* CONST FUNCTIONS */
const prints = function(msg:string){
    console.log(msg)
}

/* LAMBDA FUNCTIONS */
const pow = (x:number,y:number) => x**y
const divInt = (x:number,y:number) =>{
    const div=x/y
    return Math.floor(div)
} 

/* UNION INFERENCE */
type option = 'exit' | 'continue'
const comp = (op: option) =>{
    switch(op){
        case 'exit' : 
            console.log("Bye") 
            break
        case 'continue' :
            console.log("Let")
            break
    }
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
