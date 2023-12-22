package Partidas;

import Ayudas.Compra;
import Ayudas.Letras;
import Ayudas.SegundaDefinicion;
import Exceptions.EPalabraNoValidaException;
import Exceptions.ERoscoNoValidoException;
import Palabras.Palabra;
import java.io.Serializable;

public class Rosco implements Serializable{
    
    //Constantes:
    public static int NUM_VUELTAS_MAX = 2;
    public static final char[] ABECEDARIO = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
    //End Constantes.
    
    //Variables:
    private int num_letras;
    private int vuelta;
    private int num_Aciertos;
    private int num_Fallos;
    private Palabra[] palabras;
    //End Variables.
    
    //Constructor:
    public Rosco(int num_letras, Palabra[] palabras) throws ERoscoNoValidoException, EPalabraNoValidaException{
        //El numero ed palabras debe estar entre 1 y 25
        if(num_letras < 1 || num_letras > 25) throw new ERoscoNoValidoException("El numero de palabras del rosco esta fuera del rango valido [1-25]");
        this.num_letras = num_letras;
        //El rosco siempre se creara en la primera vuelta, la vuelta 1
        this.vuelta = 1;
        //Creamos un array con las palabras correspondientes del almacen
        this.palabras = palabras;
    }
    //End Constructor.

    //Métodos públicos:
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Palabra p : palabras){
            sb.append("\nInicial: " + p.getInicial() + "|Palabra: " + p.getPalabra() + "|Estado: ");
            if(p.getAcertada()) sb.append("acertada");
            else if(p.getFallada()) sb.append("fallada");
            else sb.append("aplazada");
            sb.append("\nAyuda: ");
            if(p.getAyuda() == null) sb.append("no utilizada.");
            else{
                //Identificamos el tipo de ayuda y lo inidicamos
                if(p.getAyuda() instanceof Compra) sb.append("palabra comprada.");
                else if(p.getAyuda() instanceof Letras) sb.append("se ha mostrado el 33% de la palabra.");
                else if(p.getAyuda() instanceof SegundaDefinicion) sb.append("se ha mostrado la segunda definicion de la palabra.");
            }
        }
        sb.append("\nNumero de letras: "+ getNumLetras());
        sb.append("\nNumero de vueltas: "+ getVuelta());
        sb.append("\nFinal Rosco");
        return sb.toString();
    }
    //End Métodos públicos.
    
    //Métodos privados:
    
    //End Métodos privados.
    
    //Gets:
    public int getNumLetras(){return this.num_letras;}
    public int getVuelta(){return this.vuelta;}
    public int getNumAciertos(){return this.num_Aciertos;}
    public int getNumFallos(){return this.num_Fallos;}
    public Palabra[] getPalabras(){
        return palabras;
    }
    public Palabra getB(){return this.palabras[1];}
    public Palabra getC(){return this.palabras[2];}
    public Palabra getD(){return this.palabras[3];}
    public Palabra getE(){return this.palabras[4];}
    public Palabra getF(){return this.palabras[5];}
    public Palabra getG(){return this.palabras[6];}
    public Palabra getH(){return this.palabras[7];}
    public Palabra getI(){return this.palabras[8];}
    public Palabra getJ(){return this.palabras[9];}
    public Palabra getL(){return this.palabras[10];}
    public Palabra getM(){return this.palabras[11];}
    public Palabra getN(){return this.palabras[12];}
    public Palabra getÑ(){return this.palabras[13];}
    public Palabra getO(){return this.palabras[14];}
    public Palabra getP(){return this.palabras[15];}
    public Palabra getQ(){return this.palabras[16];}
    public Palabra getR(){return this.palabras[17];}
    public Palabra getS(){return this.palabras[18];}
    public Palabra getT(){return this.palabras[19];}
    public Palabra getU(){return this.palabras[20];}
    public Palabra getV(){return this.palabras[21];}
    public Palabra getX(){return this.palabras[22];}
    public Palabra getY(){return this.palabras[23];}
    public Palabra getZ(){return this.palabras[24];}
    //End Gets.
    
    //Sets:
    public void setNumLetras(int num_letras){this.num_letras=num_letras;}
    public boolean setVuelta(int nuevoValor){
        //Devolvemos true si el nuevoValor esta dentro del rango de valores posibles y false sino
        if(nuevoValor >= 1 && nuevoValor <= 2){
            vuelta = nuevoValor;
            return true;
        }
        else return false;
    }
    public boolean setNumAciertos(int nuevoValor){
        //Si se puede realizar devolvemos true, sino false
        if(nuevoValor >= 0){
            num_Aciertos = nuevoValor;
            return true;
        }
        else return false;
    }
    public boolean setNumFallos(int nuevoValor){
        //Si se puede realizar devolvemos true, sino false
        if(nuevoValor >= 0){
            this.num_Fallos = nuevoValor;
            return true;
        }
        else return false;
    }
    public void setA(Palabra A){this.palabras[0]=A;}
    public void setB(Palabra B){this.palabras[1]=B;}
    public void setC(Palabra C){this.palabras[2]=C;}
    public void setD(Palabra D){this.palabras[3]=D;}
    public void setE(Palabra E){this.palabras[4]=E;}
    public void setF(Palabra F){this.palabras[5]=F;}
    public void setG(Palabra G){this.palabras[6]=G;}
    public void setH(Palabra H){this.palabras[7]=H;}
    public void setI(Palabra I){this.palabras[8]=I;}
    public void setJ(Palabra J){this.palabras[9]=J;}
    public void setL(Palabra L){this.palabras[10]=L;}
    public void setM(Palabra M){this.palabras[11]=M;}
    public void setN(Palabra N){this.palabras[12]=N;}
    public void setÑ(Palabra Ñ){this.palabras[13]=Ñ;}
    public void setO(Palabra O){this.palabras[14]=O;}
    public void setP(Palabra P){this.palabras[15]=P;}
    public void setQ(Palabra Q){this.palabras[16]=Q;}
    public void setR(Palabra R){this.palabras[17]=R;}
    public void setS(Palabra S){this.palabras[18]=S;}
    public void setT(Palabra T){this.palabras[19]=T;}
    public void setU(Palabra U){this.palabras[20]=U;}
    public void setV(Palabra V){this.palabras[21]=V;}
    public void setX(Palabra X){this.palabras[22]=X;}
    public void setY(Palabra Y){this.palabras[23]=Y;}
    public void setZ(Palabra Z){this.palabras[24]=Z;}
    //End Sets.
    
}
