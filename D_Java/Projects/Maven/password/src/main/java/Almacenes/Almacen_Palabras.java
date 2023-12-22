package Almacenes;

import Palabras.Palabra;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Almacen_Palabras implements Serializable {

    //Constantes:
    private static final long serialVersionUID = 2;
    //End Constantes.

    //Variables:
    private ArrayList<Palabra> palabras_A;
    private ArrayList<Palabra> palabras_B;
    private ArrayList<Palabra> palabras_C;
    private ArrayList<Palabra> palabras_D;
    private ArrayList<Palabra> palabras_E;
    private ArrayList<Palabra> palabras_F;
    private ArrayList<Palabra> palabras_G;
    private ArrayList<Palabra> palabras_H;
    private ArrayList<Palabra> palabras_I;
    private ArrayList<Palabra> palabras_J;
    private ArrayList<Palabra> palabras_L;
    private ArrayList<Palabra> palabras_M;
    private ArrayList<Palabra> palabras_N;
    private ArrayList<Palabra> palabras_Ñ;
    private ArrayList<Palabra> palabras_O;
    private ArrayList<Palabra> palabras_P;
    private ArrayList<Palabra> palabras_Q;
    private ArrayList<Palabra> palabras_R;
    private ArrayList<Palabra> palabras_S;
    private ArrayList<Palabra> palabras_T;
    private ArrayList<Palabra> palabras_U;
    private ArrayList<Palabra> palabras_V;
    private ArrayList<Palabra> palabras_X;
    private ArrayList<Palabra> palabras_Y;
    private ArrayList<Palabra> palabras_Z;
    //End Variables.

    //Constructor:
    public Almacen_Palabras() {
        palabras_A = new ArrayList<>();
        palabras_B = new ArrayList<>();
        palabras_C = new ArrayList<>();
        palabras_D = new ArrayList<>();
        palabras_E = new ArrayList<>();
        palabras_F = new ArrayList<>();
        palabras_G = new ArrayList<>();
        palabras_H = new ArrayList<>();
        palabras_I = new ArrayList<>();
        palabras_J = new ArrayList<>();
        palabras_L = new ArrayList<>();
        palabras_M = new ArrayList<>();
        palabras_N = new ArrayList<>();
        palabras_Ñ = new ArrayList<>();
        palabras_O = new ArrayList<>();
        palabras_P = new ArrayList<>();
        palabras_Q = new ArrayList<>();
        palabras_R = new ArrayList<>();
        palabras_S = new ArrayList<>();
        palabras_T = new ArrayList<>();
        palabras_U = new ArrayList<>();
        palabras_V = new ArrayList<>();
        palabras_X = new ArrayList<>();
        palabras_Y = new ArrayList<>();
        palabras_Z = new ArrayList<>();
        //Palabra por defecto:

    }
    //End Constructor.

    //Métodos públicos:
    public void cargarFichero(String nombreFichero) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreFichero));
        Almacen_Palabras almacen = (Almacen_Palabras) entrada.readObject();
        palabras_A = almacen.palabras_A;
        palabras_B = almacen.palabras_B;
        palabras_C = almacen.palabras_C;
        palabras_D = almacen.palabras_D;
        palabras_E = almacen.palabras_E;
        palabras_F = almacen.palabras_F;
        palabras_G = almacen.palabras_G;
        palabras_H = almacen.palabras_H;
        palabras_I = almacen.palabras_I;
        palabras_J = almacen.palabras_J;
        palabras_L = almacen.palabras_L;
        palabras_M = almacen.palabras_M;
        palabras_N = almacen.palabras_N;
        palabras_Ñ = almacen.palabras_Ñ;
        palabras_O = almacen.palabras_O;
        palabras_P = almacen.palabras_P;
        palabras_Q = almacen.palabras_Q;
        palabras_R = almacen.palabras_R;
        palabras_S = almacen.palabras_S;
        palabras_T = almacen.palabras_T;
        palabras_U = almacen.palabras_U;
        palabras_V = almacen.palabras_V;
        palabras_X = almacen.palabras_X;
        palabras_Y = almacen.palabras_Y;
        palabras_Z = almacen.palabras_Z;
        entrada.close();
    }

    public void grabarFichero(String nombreFichero) throws FileNotFoundException, IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreFichero));
        salida.writeObject(this);
        salida.close();
    }

    public Palabra getPalabra(char letra) {
        //Devolvemos una palabra cualquiera que empiece por la letra indicada
        ArrayList<Palabra> listaDondeBuscar = localizarLetra(String.valueOf(letra));
        //Si la lista esta vacia devolvemos null
        if (listaDondeBuscar.isEmpty()) {
            return null;
        }
        //Sino devolvemos un elemento de forma aleatoria
        int posicion = (int) (Math.random() * listaDondeBuscar.size());
        return (Palabra) listaDondeBuscar.toArray()[posicion];
    }

    public Palabra getPalabra(String nombrePalabra) {
        //Busca el jugador por su nombre y lo delvuelve o null si no lo encuentra
        Iterator<Palabra> it = localizarLetra(nombrePalabra).iterator();
        while (it.hasNext()) {
            Palabra siguiente = it.next();
            if (siguiente.getPalabra().toString().equalsIgnoreCase(nombrePalabra)) {
                return siguiente;
            }
        }
        return null;
    }
    
    public boolean existePalabra(String palabra){
        ArrayList<Palabra> array = localizarLetra(palabra);
        for(Palabra p : array){
            if(palabra.equals(p.getPalabra().toString())) return true;
        }
        return false;
    }

    public ArrayList<Palabra> localizarLetra(String palabra) {
        switch (palabra.toUpperCase().charAt(0)) {
            case 'A':
                return palabras_A;
            case 'B':
                return palabras_B;
            case 'C':
                return palabras_C;
            case 'D':
                return palabras_D;
            case 'E':
                return palabras_E;
            case 'F':
                return palabras_F;
            case 'G':
                return palabras_G;
            case 'H':
                return palabras_H;
            case 'I':
                return palabras_I;
            case 'J':
                return palabras_J;
            case 'L':
                return palabras_L;
            case 'M':
                return palabras_M;
            case 'N':
                return palabras_N;
            case 'Ñ':
                return palabras_Ñ;
            case 'O':
                return palabras_O;
            case 'P':
                return palabras_P;
            case 'Q':
                return palabras_Q;
            case 'R':
                return palabras_R;
            case 'S':
                return palabras_S;
            case 'T':
                return palabras_T;
            case 'U':
                return palabras_U;
            case 'V':
                return palabras_V;
            case 'X':
                return palabras_X;
            case 'Y':
                return palabras_Y;
            case 'Z':
                return palabras_Z;
            default:
                return null;
        }
    }

    public void borrarPalabra(Palabra p) {
        switch (p.getInicial()) {
            case 'A', 'a' ->
                palabras_A.remove(p);
            case 'B', 'b' ->
                palabras_B.remove(p);
            case 'C', 'c' ->
                palabras_C.remove(p);
            case 'D', 'd' ->
                palabras_D.remove(p);
            case 'E', 'e' ->
                palabras_E.remove(p);
            case 'F', 'f' ->
                palabras_F.remove(p);
            case 'G', 'g' ->
                palabras_G.remove(p);
            case 'H', 'h' ->
                palabras_H.remove(p);
            case 'I', 'i' ->
                palabras_I.remove(p);
            case 'J', 'j' ->
                palabras_J.remove(p);
            case 'L', 'l' ->
                palabras_L.remove(p);
            case 'M', 'm' ->
                palabras_M.remove(p);
            case 'N', 'n' ->
                palabras_N.remove(p);
            case 'Ñ', 'ñ' ->
                palabras_Ñ.remove(p);
            case 'O', 'o' ->
                palabras_O.remove(p);
            case 'P', 'p' ->
                palabras_P.remove(p);
            case 'Q', 'q' ->
                palabras_Q.remove(p);
            case 'R', 'r' ->
                palabras_R.remove(p);
            case 'S', 's' ->
                palabras_S.remove(p);
            case 'T', 't' ->
                palabras_T.remove(p);
            case 'U', 'u' ->
                palabras_U.remove(p);
            case 'V', 'v' ->
                palabras_V.remove(p);
            case 'X', 'x' ->
                palabras_X.remove(p);
            case 'Y', 'y' ->
                palabras_Y.remove(p);
            case 'Z', 'z' ->
                palabras_Z.remove(p);
        }
    }

    public void añadirPalabra(Palabra p) {
        switch (p.getInicial()) {
            case 'A', 'a' ->
                palabras_A.add(p);
            case 'B', 'b' ->
                palabras_B.add(p);
            case 'C', 'c' ->
                palabras_C.add(p);
            case 'D', 'd' ->
                palabras_D.add(p);
            case 'E', 'e' ->
                palabras_E.add(p);
            case 'F', 'f' ->
                palabras_F.add(p);
            case 'G', 'g' ->
                palabras_G.add(p);
            case 'H', 'h' ->
                palabras_H.add(p);
            case 'I', 'i' ->
                palabras_I.add(p);
            case 'J', 'j' ->
                palabras_J.add(p);
            case 'L', 'l' ->
                palabras_L.add(p);
            case 'M', 'm' ->
                palabras_M.add(p);
            case 'N', 'n' ->
                palabras_N.add(p);
            case 'Ñ', 'ñ' ->
                palabras_Ñ.add(p);
            case 'O', 'o' ->
                palabras_O.add(p);
            case 'P', 'p' ->
                palabras_P.add(p);
            case 'Q', 'q' ->
                palabras_Q.add(p);
            case 'R', 'r' ->
                palabras_R.add(p);
            case 'S', 's' ->
                palabras_S.add(p);
            case 'T', 't' ->
                palabras_T.add(p);
            case 'U', 'u' ->
                palabras_U.add(p);
            case 'V', 'v' ->
                palabras_V.add(p);
            case 'X', 'x' ->
                palabras_X.add(p);
            case 'Y', 'y' ->
                palabras_Y.add(p);
            case 'Z', 'z' ->
                palabras_Z.add(p);
        }
    }

    public String stringAlmacenPalabras() {
        return StringPalabras(palabras_A, 'A') + StringPalabras(palabras_B, 'B')
                + StringPalabras(palabras_C, 'C') + StringPalabras(palabras_D, 'D')
                + StringPalabras(palabras_E, 'E') + StringPalabras(palabras_F, 'F')
                + StringPalabras(palabras_G, 'G') + StringPalabras(palabras_H, 'H')
                + StringPalabras(palabras_I, 'I') + StringPalabras(palabras_J, 'J')
                + StringPalabras(palabras_L, 'L') + StringPalabras(palabras_M, 'M')
                + StringPalabras(palabras_N, 'N') + StringPalabras(palabras_Ñ, 'Ñ')
                + StringPalabras(palabras_O, 'O') + StringPalabras(palabras_P, 'P')
                + StringPalabras(palabras_Q, 'Q') + StringPalabras(palabras_R, 'R')
                + StringPalabras(palabras_S, 'S') + StringPalabras(palabras_T, 'T')
                + StringPalabras(palabras_U, 'U') + StringPalabras(palabras_V, 'V')
                + StringPalabras(palabras_X, 'X') + StringPalabras(palabras_Y, 'Y')
                + StringPalabras(palabras_Z, 'Z');
    }

    public Palabra palabraRandom(int indice) {
        int ran;
        Palabra p = null;
        switch (indice) {
            case 0:
                ran = (int) (Math.random() * (palabras_A.size() + 1));
                p = palabras_A.get(ran);
                break;
            case 1:
                ran = (int) (Math.random() * (palabras_B.size() + 1));
                p = palabras_B.get(ran);
                break;
            case 2:
                ran = (int) (Math.random() * (palabras_C.size() + 1));
                p = palabras_C.get(ran);
                break;
            case 3:
                ran = (int) (Math.random() * (palabras_D.size() + 1));
                p = palabras_D.get(ran);
                break;
            case 4:
                ran = (int) (Math.random() * (palabras_E.size() + 1));
                p = palabras_E.get(ran);
                break;
            case 5:
                ran = (int) (Math.random() * (palabras_F.size() + 1));
                p = palabras_F.get(ran);
                break;
            case 6:
                ran = (int) (Math.random() * (palabras_G.size() + 1));
                p = palabras_G.get(ran);
                break;
            case 7:
                ran = (int) (Math.random() * (palabras_H.size() + 1));
                p = palabras_H.get(ran);
                break;
            case 8:
                ran = (int) (Math.random() * (palabras_I.size() + 1));
                p = palabras_I.get(ran);
                break;
            case 9:
                ran = (int) (Math.random() * (palabras_J.size() + 1));
                p = palabras_J.get(ran);
                break;
            case 10:
                ran = (int) (Math.random() * (palabras_L.size() + 1));
                p = palabras_L.get(ran);
                break;
            case 11:
                ran = (int) (Math.random() * (palabras_M.size() + 1));
                p = palabras_M.get(ran);
                break;
            case 12:
                ran = (int) (Math.random() * (palabras_N.size() + 1));
                p = palabras_N.get(ran);
                break;
            case 13:
                ran = (int) (Math.random() * (palabras_Ñ.size() + 1));
                p = palabras_Ñ.get(ran);
                break;
            case 14:
                ran = (int) (Math.random() * (palabras_O.size() + 1));
                p = palabras_O.get(ran);
                break;
            case 15:
                ran = (int) (Math.random() * (palabras_P.size() + 1));
                p = palabras_P.get(ran);
                break;
            case 16:
                ran = (int) (Math.random() * (palabras_Q.size() + 1));
                p = palabras_Q.get(ran);
                break;
            case 17:
                ran = (int) (Math.random() * (palabras_R.size() + 1));
                p = palabras_R.get(ran);
                break;
            case 18:
                ran = (int) (Math.random() * (palabras_S.size() + 1));
                p = palabras_S.get(ran);
                break;
            case 19:
                ran = (int) (Math.random() * (palabras_T.size() + 1));
                p = palabras_T.get(ran);
                break;
            case 20:
                ran = (int) (Math.random() * (palabras_U.size() + 1));
                p = palabras_U.get(ran);
                break;
            case 21:
                ran = (int) (Math.random() * (palabras_V.size() + 1));
                p = palabras_V.get(ran);
                break;
            case 22:
                ran = (int) (Math.random() * (palabras_X.size() + 1));
                p = palabras_X.get(ran);
                break;
            case 23:
                ran = (int) (Math.random() * (palabras_Y.size() + 1));
                p = palabras_Y.get(ran);
                break;
            case 24:
                ran = (int) (Math.random() * (palabras_Z.size() + 1));
                p = palabras_Z.get(ran);
                break;
        }
        return p;
    }

    public String[] arrayStringListaPalabras(char letra) {
        String[] array = null;
        switch (letra) {
            case 'A', 'a' ->
                array = toArray(palabras_A);
            case 'B', 'b' ->
                array = toArray(palabras_B);
            case 'C', 'c' ->
                array = toArray(palabras_C);
            case 'D', 'd' ->
                array = toArray(palabras_D);
            case 'E', 'e' ->
                array = toArray(palabras_E);
            case 'F', 'f' ->
                array = toArray(palabras_F);
            case 'G', 'g' ->
                array = toArray(palabras_G);
            case 'H', 'h' ->
                array = toArray(palabras_H);
            case 'I', 'i' ->
                array = toArray(palabras_I);
            case 'J', 'j' ->
                array = toArray(palabras_J);
            case 'L', 'l' ->
                array = toArray(palabras_L);
            case 'M', 'm' ->
                array = toArray(palabras_M);
            case 'N', 'n' ->
                array = toArray(palabras_N);
            case 'Ñ', 'ñ' ->
                array = toArray(palabras_Ñ);
            case 'O', 'o' ->
                array = toArray(palabras_O);
            case 'P', 'p' ->
                array = toArray(palabras_P);
            case 'Q', 'q' ->
                array = toArray(palabras_Q);
            case 'R', 'r' ->
                array = toArray(palabras_R);
            case 'S', 's' ->
                array = toArray(palabras_S);
            case 'T', 't' ->
                array = toArray(palabras_T);
            case 'U', 'u' ->
                array = toArray(palabras_U);
            case 'V', 'v' ->
                array = toArray(palabras_V);
            case 'X', 'x' ->
                array = toArray(palabras_X);
            case 'Y', 'y' ->
                array = toArray(palabras_Y);
            case 'Z', 'z' ->
                array = toArray(palabras_Z);
        }
        return array;
    }

    public Palabra recuperarPorNombre(String nombre) {
        ArrayList<Palabra> array;
        switch (nombre.charAt(0)) {
            case 'A', 'a' ->
                array = palabras_A;
            case 'B', 'b' ->
                array = palabras_B;
            case 'C', 'c' ->
                array = palabras_C;
            case 'D', 'd' ->
                array = palabras_D;
            case 'E', 'e' ->
                array = palabras_E;
            case 'F', 'f' ->
                array = palabras_F;
            case 'G', 'g' ->
                array = palabras_G;
            case 'H', 'h' ->
                array = palabras_H;
            case 'I', 'i' ->
                array = palabras_I;
            case 'J', 'j' ->
                array = palabras_J;
            case 'L', 'l' ->
                array = palabras_L;
            case 'M', 'm' ->
                array = palabras_M;
            case 'N', 'n' ->
                array = palabras_N;
            case 'Ñ', 'ñ' ->
                array = palabras_Ñ;
            case 'O', 'o' ->
                array = palabras_O;
            case 'P', 'p' ->
                array = palabras_P;
            case 'Q', 'q' ->
                array = palabras_Q;
            case 'R', 'r' ->
                array = palabras_R;
            case 'S', 's' ->
                array = palabras_S;
            case 'T', 't' ->
                array = palabras_T;
            case 'U', 'u' ->
                array = palabras_U;
            case 'V', 'v' ->
                array = palabras_V;
            case 'X', 'x' ->
                array = palabras_X;
            case 'Y', 'y' ->
                array = palabras_Y;
            case 'Z', 'z' ->
                array = palabras_Z;
            default ->
                array = null;
        }
        for (Palabra p : array) {
            if (p.getPalabra().toString().equals(nombre)) {
                return p;
            }
        }
        return null;
    }
    //End Métodos públicos.

    //Métodos privados:
    private String StringPalabras(ArrayList<Palabra> a, char inicial) {
        if (!(a.isEmpty())) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nLista ").append(inicial).append(":");
            for (Palabra p : a) {
                sb.append("\n Palabra: ").append(p.getPalabra());
                sb.append("\n Def1: ").append(p.getDef1().toString());
                sb.append("\n Def2: ").append(p.getDef2().toString());
            }
            return sb.toString();
        } else {
            return "\nLista " + inicial + ": Vacía\n";
        }
    }

    private String[] toArray(ArrayList<Palabra> a) {
        String[] array = new String[a.size()];
        int counter = 0;
        for (Palabra p : a) {
            array[counter] = p.getPalabra().toString();
            counter++;
        }
        return array;
    }
    //End Métodos privados.

    //Gets:
    public ArrayList<Palabra> getPalabrasA() {
        return palabras_A;
    }

    public ArrayList<Palabra> getPalabrasB() {
        return palabras_B;
    }

    public ArrayList<Palabra> getPalabrasC() {
        return palabras_C;
    }

    public ArrayList<Palabra> getPalabrasD() {
        return palabras_D;
    }

    public ArrayList<Palabra> getPalabrasE() {
        return palabras_E;
    }

    public ArrayList<Palabra> getPalabrasF() {
        return palabras_F;
    }

    public ArrayList<Palabra> getPalabrasG() {
        return palabras_G;
    }

    public ArrayList<Palabra> getPalabrasH() {
        return palabras_H;
    }

    public ArrayList<Palabra> getPalabrasI() {
        return palabras_I;
    }

    public ArrayList<Palabra> getPalabrasJ() {
        return palabras_J;
    }

    public ArrayList<Palabra> getPalabrasL() {
        return palabras_L;
    }

    public ArrayList<Palabra> getPalabrasM() {
        return palabras_M;
    }

    public ArrayList<Palabra> getPalabrasN() {
        return palabras_N;
    }

    public ArrayList<Palabra> getPalabrasÑ() {
        return palabras_Ñ;
    }

    public ArrayList<Palabra> getPalabrasO() {
        return palabras_O;
    }

    public ArrayList<Palabra> getPalabrasP() {
        return palabras_P;
    }

    public ArrayList<Palabra> getPalabrasQ() {
        return palabras_Q;
    }

    public ArrayList<Palabra> getPalabrasR() {
        return palabras_R;
    }

    public ArrayList<Palabra> getPalabrasS() {
        return palabras_S;
    }

    public ArrayList<Palabra> getPalabrasT() {
        return palabras_T;
    }

    public ArrayList<Palabra> getPalabrasU() {
        return palabras_U;
    }

    public ArrayList<Palabra> getPalabrasV() {
        return palabras_V;
    }

    public ArrayList<Palabra> getPalabrasX() {
        return palabras_X;
    }

    public ArrayList<Palabra> getPalabrasY() {
        return palabras_Y;
    }

    public ArrayList<Palabra> getPalabrasZ() {
        return palabras_Z;
    }
    //End Gets.

    //Sets:
    public void setPalabrasA(ArrayList<Palabra> palabras_A) {
        this.palabras_A = palabras_A;
    }

    public void setPalabrasB(ArrayList<Palabra> palabras_B) {
        this.palabras_B = palabras_B;
    }

    public void setPalabrasC(ArrayList<Palabra> palabras_C) {
        this.palabras_C = palabras_C;
    }

    public void setPalabrasD(ArrayList<Palabra> palabras_D) {
        this.palabras_D = palabras_D;
    }

    public void setPalabrasE(ArrayList<Palabra> palabras_E) {
        this.palabras_E = palabras_E;
    }

    public void setPalabrasF(ArrayList<Palabra> palabras_F) {
        this.palabras_F = palabras_F;
    }

    public void setPalabrasG(ArrayList<Palabra> palabras_G) {
        this.palabras_G = palabras_G;
    }

    public void setPalabrasH(ArrayList<Palabra> palabras_H) {
        this.palabras_H = palabras_H;
    }

    public void setPalabrasI(ArrayList<Palabra> palabras_I) {
        this.palabras_I = palabras_I;
    }

    public void setPalabrasJ(ArrayList<Palabra> palabras_J) {
        this.palabras_J = palabras_J;
    }

    public void setPalabrasL(ArrayList<Palabra> palabras_L) {
        this.palabras_L = palabras_L;
    }

    public void setPalabrasM(ArrayList<Palabra> palabras_M) {
        this.palabras_M = palabras_M;
    }

    public void setPalabrasN(ArrayList<Palabra> palabras_N) {
        this.palabras_N = palabras_N;
    }

    public void setPalabrasÑ(ArrayList<Palabra> palabras_Ñ) {
        this.palabras_Ñ = palabras_Ñ;
    }

    public void setPalabrasO(ArrayList<Palabra> palabras_O) {
        this.palabras_O = palabras_O;
    }

    public void setPalabrasP(ArrayList<Palabra> palabras_P) {
        this.palabras_P = palabras_P;
    }

    public void setPalabrasQ(ArrayList<Palabra> palabras_Q) {
        this.palabras_Q = palabras_Q;
    }

    public void setPalabrasR(ArrayList<Palabra> palabras_R) {
        this.palabras_R = palabras_R;
    }

    public void setPalabrasS(ArrayList<Palabra> palabras_S) {
        this.palabras_S = palabras_S;
    }

    public void setPalabrasT(ArrayList<Palabra> palabras_T) {
        this.palabras_T = palabras_T;
    }

    public void setPalabrasU(ArrayList<Palabra> palabras_U) {
        this.palabras_U = palabras_U;
    }

    public void setPalabrasV(ArrayList<Palabra> palabras_V) {
        this.palabras_V = palabras_V;
    }

    public void setPalabrasX(ArrayList<Palabra> palabras_X) {
        this.palabras_X = palabras_X;
    }

    public void setPalabrasY(ArrayList<Palabra> palabras_Y) {
        this.palabras_Y = palabras_Y;
    }

    public void setPalabrasZ(ArrayList<Palabra> palabras_Z) {
        this.palabras_Z = palabras_Z;
    }
    //End Sets.
}
