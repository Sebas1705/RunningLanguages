const countSmileyes=a=>{
    let count = 0;
    const check=s=>{
        let i = s.charAt(0), f=s.charAt(s.length);
        if((i===":"||i==";")&&(f===")"||f==="D")){
            if(a.length==2&&(s.charAt(1)==="-"||s.charAt(1)==="~")) return true;
            if(a.length==1) return true;
        }
        return false;
    }
    a.map(b=>check(b)?count++:-1);

    return count;
}


let l = [':)', ';(', ';}', ':-D'];
document.write(l);
document.write("<br>");
document.write(countSmileyes(l));