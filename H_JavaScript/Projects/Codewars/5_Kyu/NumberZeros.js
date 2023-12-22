const zeros = n=>countTrailingZeros(String(factorial(n)).split(""));

const factorial=a=>(a==1||a==0)?a:a*factorial(a-1);
const countTrailingZeros=b=>{
    for(let i=b.length-1,x=0;i>=0;i--){
        if(b[i]=="0")x++;
        else return x;
    }    
}

let n = 30;
document.write(n);
document.write("<br>");
document.write(factorial(n));
document.write("<br>");
document.write(String(factorial(n)).split(""));
document.write("<br>");
document.write(zeros(n));