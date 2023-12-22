const solution = a=>a.split("").map(x=>x=(x===x.toUpperCase())?" "+x:x).join("");

let l = "separadoConstante";
document.write(l);
document.write("<br>");
document.write(solution(l));