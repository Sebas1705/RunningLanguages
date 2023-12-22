function sortArray(array) {
    let tempArray = new Array(), j=0;
    for(n of array)if(n%2==1)tempArray[tempArray.length]=n;
    tempArray.sort((a,b)=>{
        if(a<b)return -1;
        else return 1;
    });
    for(i in array)if(array[i]%2==1)array[i]=tempArray[j++];
    return array;
}

const array = [ -3, -25, 20, 33, -45, 24, 39, -43, -34 ];
document.write(sortArray(array));