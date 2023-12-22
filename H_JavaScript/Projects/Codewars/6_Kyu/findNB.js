// function findNb(m) {
//     let n = 1, nm = m;
//     while(m>0){
//         m-=(n++)**3;
//         if(m==0)return n-1;
//     }
//     return -1;
// }

const findNb = m =>{
    let n = 1, nm = m;
    while(m>0){
        m-=(n++)**3;
        if(m==0)return n-1;
    }
    return -1;
}
let m = 4183059834009
document.write(m)
document.write("<br>")
document.write(findNb(m))