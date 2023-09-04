
try {
    let result = 10 / 0
    if(result==Infinity) throw new Error("Result cannot be Infinity, check operands")
    console.log(result)
} catch (error) {
    console.error("Error:", error.message);
} finally {
    console.log("Always execute.");
}
  
console.log("Ending...");