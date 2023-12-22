const pigIt = s => s.split(" ").map(x=>(x.toUpperCase().charCodeAt(0)>64&&x.toUpperCase().charCodeAt(0)<91)?x.slice(1,x.length)+x.charAt(0)+"ay":x).join(" ");

let s = "Pig latin is cool";
document.write(s);
document.write("<br>");
document.write(pigIt(s))