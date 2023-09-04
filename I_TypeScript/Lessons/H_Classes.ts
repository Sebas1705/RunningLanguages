
/* BASIC CLASS */
class Four_sides {
    
    static N_SIDES = 4

    // PRIVATE ATTRIBUTES
    protected sideA:number
    protected sideB:number
    protected sideC:number
    protected sideD:number
    
    public constructor(sideA:number=1,sideB:number=1,sideC:number=1,sideD:number=1) {
        this.sideA=sideA
        this.sideB=sideB
        this.sideC=sideC
        this.sideD=sideD
    }
    // Getter
    public get getSideA() { return this.sideA }
    public get getSideB() { return this.sideB }
    public get getSideC() { return this.sideC }
    public get getSideD() { return this.sideD }
    // METHODS
    public calcPerimeter(){return this.calc_Perimeter()}
    static PI(){return Math.PI}
    // PRIVATE METHODS
    private calc_Perimeter(){return this.sideA+this.sideB+this.sideC+this.sideD}
}

/* INHERITANCE */
class Rect extends Four_sides {
    constructor(height:number,width:number){
        super(height,width,height,width)
    }
    calcArea(){
        return this.sideA*this.sideC
    }
}

/* ENUM */
enum Week{
    MONDAY=3,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY
}

let rect = new Rect(4,5)
console.log(rect.calcArea())
console.log(rect.getSideA)
console.log(rect instanceof Rect)
console.log(rect instanceof Four_sides)