String.prototype.toJadenCase = function () {
    const array = this.split(" ");
    let result = "";
    for(a of array)
        result+=a.replace(a.charAt(0),a.charAt(0).toUpperCase())+" ";
    return result.substring(0, result.length-1);
};



var str = "How can mirrors be real if our eyes aren't real";
document.write(str.toJadenCase())