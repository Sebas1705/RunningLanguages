// const humanReadable = s =>{
//     const digitFormat = a =>(a<10)?"0"+a:""+a;
//     return [digitFormat(Math.floor(s/3600)),digitFormat(Math.floor(s/60)%60),digitFormat(s%60)].join(":");
// };

const humanReadable = s =>[Math.floor(s/3600),Math.floor(s/60)%60,s%60].map(c=>(c<10)?"0"+c:String(c)).join(":");

let s = 3990;

document.write(s);
document.write("<br>");
document.write(humanReadable(s));