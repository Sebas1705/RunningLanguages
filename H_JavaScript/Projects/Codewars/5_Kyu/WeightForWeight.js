const orderWeight = s => s.split(' ').sort((a,b) => weight(a)-weight(b)||a.localeCompare(b)).join(' ');
const weight = s => s.split('').reduce((a,e)=>a+e,0);
let s = "56 65 74 100 99 68 86 180 90";
document.write(s);
document.write("<br>");
document.write("Result: "+orderWeight(s)+"<br>");
document.write("Correct:"+"100 180 90 56 65 74 68 86 99")