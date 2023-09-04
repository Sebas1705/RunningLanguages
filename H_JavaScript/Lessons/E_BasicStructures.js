
/* IF-ELSE */
let n = 100
if (n==100) {
    console.log("Equal hundred")
}
else if (n<100) console.log("Less than hundred")
else {
    console.log("Greater than hundred")
}

/* SWITCH */
switch (n){
    case 1:
        console.log("One")
    case 2:
        console.log("Two")
    case 100:
        console.log("One hundred")
        break //Scape out the logic structure
    default:
        console.log("Not specified")
}

/* WHILE */
while(n>90){
    console.log(n--)
}

/* DO-WHILE */
do{
    console.log(n++)
}while(n<=100)

/* FOR */
for(let i=0;i<20;i++){
    if(i%2==0)continue //Jump to the next loop
    console.log(i)
}

/* FOR-OF */
for(let i of [1,2,3,4,22,12]){ //Arrays or Strings
    console.log(i)
}

/* FOR-IN */
const person={
    name: 'John',
    age: 21,
    worker: true
}
for(let i in person){
    console.log(i+": "+person[i])
}
