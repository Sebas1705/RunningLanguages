const narcissistic = a => String(a).split("").map((x,i,arr)=>x**arr.length).reduce((c,a)=>c+a)==a;

let n = 7;
document.write(n)
document.write("<br>")
document.write(narcissistic(n))
