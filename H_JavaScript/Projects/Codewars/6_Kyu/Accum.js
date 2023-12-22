// const accum = s =>{
//     let i = 1, out = "", em = true;
//     for(c of s.split("")){
//         for(let j=0;j<i;j++){
//             if(em)out+=c.toUpperCase();
//             else out+=c.toLowerCase();
//             em = false;
//         }
//         out+="-";
//         i++;
//         em = true;
//     }
//     return out.slice(0, out.length-1);
// }

const accum = s => s.split("").map((c,i)=>(c.toUpperCase() + c.toLowerCase().repeat(i))).join("-")
let l = "abcd"
document.write(l.split(""))
document.write("<br>")
document.write(accum("abcd"))