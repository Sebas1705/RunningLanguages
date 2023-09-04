
/* BASIC CLASS */
class Four_sides {
    
    static N_SIDES = 4

    // PRIVATE ATTRIBUTES
    #_sideA
    #_sideB
    #_sideC
    #_sideD
    
    constructor(sideA=1,sideB=1,sideC=1,sideD=1) {
        this._sideA=sideA
        this._sideB=sideB
        this._sideC=sideC
        this._sideD=sideD
    }
    // Getter
    get sideA() { return this._sideA }
    get sideB() { return this._sideB }
    get sideC() { return this._sideC }
    get sideD() { return this._sideD }
    // METHODS
    calcPerimeter(){return this.#calc_Perimeter}
    static PI(){return Math.PI}
    // PRIVATE METHODS
    #calc_Perimeter(){return this.sideA+this.sideB+this.sideC+this.sideD}
}

class Rect extends Four_sides {
    constructor(height,width){
        super(height,width,height,width)
    }
    calcArea(){
        return this.sideA*this.sideC
    }
}

let rect = new Rect(4,5)
console.log(rect.calcArea())
console.log(rect instanceof Rect)
console.log(rect instanceof Four_sides)