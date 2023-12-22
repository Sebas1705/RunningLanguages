package Avanzado.F_Comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Casa> list = new ArrayList<>();
        list.add(new Casa(400, 3));
        list.add(new Casa(100, 3));
        list.add(new Casa(500, 3));
        list.add(new Casa(800, 3));

        for(Casa c : list) {System.out.println(c);}
        System.out.println("\n");

        Collections.sort(list, new MiComparator());

        for(Casa c : list) {System.out.println(c);}
        System.out.println("\n");
    }
}
