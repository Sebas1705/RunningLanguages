// function isIsogram(str){
//     return str.length === new Set(str).size;
// }

const isIsogram = a=>{return a.length === new Set(a).size};

let word = "Supercalifragilisticoespialidoso";
document.write(word+"<br>");
document.write(isIsogram("-IsIsogram: "+word));