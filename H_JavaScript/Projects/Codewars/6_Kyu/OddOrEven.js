// function oddOrEven(array) {
//     let sum = 0;
//     for(n of array)sum+=n;
//     return (sum%2) ? "odd" : "even";
// }

// function oddOrEven(array) {
//     return((array.reduce((a,b)=>(a+b),0))%2)?"odd":"even";
// }

const oddOrEven = a=>a.reduce((a,b)=>(a+b),0)%2?"odd":"even";

document.write(oddOrEven([]))