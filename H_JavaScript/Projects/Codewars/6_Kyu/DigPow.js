function digPow(n, p){
    let arry = (""+n).split(""), number = 0, pow = p, k;
    for(char of arry){
      number+=(char**pow);
      pow++;
    }
    k = number/n;
    if(k>0&&Number.isInteger(k)) return k;
    else return -1;
}

document.write(digPow(89,1))
document.write("<br>")
document.write(digPow(92,1))
document.write("<br>")
document.write(digPow(46288,3))