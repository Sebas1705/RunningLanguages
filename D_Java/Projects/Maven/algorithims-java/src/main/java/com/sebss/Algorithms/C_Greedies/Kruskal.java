package com.sebss.Algorithms.C_Greedies;

public class Kruskal {
    
    public static int Kruskal(int[] us,int[] vs,int[] costes,int n){
        //Creamos indices
        int[] indices=new int[costes.length];
        for(int i=0;i<indices.length;i++)indices[i]=i;
        //Ordenamos los datos tenienedo en cuenta el coste por burbuja
        for (int i=1;i<indices.length;i++){
            for (int j=0;j<indices.length-i;j++){
                if (costes[indices[j]]>costes[indices[j+1]]) {
                    int aux=indices[j];
                    indices[j]=indices[j+1];
                    indices[j+1]=aux;
                }
            }
        }
        // calcula el coste m�nimo y los arcos correspondientes
        // grafo como lista de adyacencia
        // presupone que los arcos vienen ordenados en orden creciente de coste
        // vectores que representan los arcos del MST (or�genes y destinos)
        int[] orig = new int[n-1];
        int[] dest = new int[n-1];
        int a = 0;
        int coste = 0;
        // representaci�n impl�cita del bosque de nodos que forman el MST
        int[] conjs = new int[n];
        for (int i=0; i<n; i++)
            conjs[i] = i;
        // bucle voraz
        for (int i=0; i<us.length && a<n; i++) {
            // se selecciona el arco m�s corto
            int u = us[indices[i]];
            int v = vs[indices[i]];
            // se halla el conjunto disjunto de sus nodos
            int conju = conjs[u];
            int conjv = conjs[v];
            // se comprueba si pertenecen a conjuntos disjuntos
            if (conju != conjv) {
                orig[a] = u;
                dest[a] = v;
                a++;
                coste += costes[indices[i]];
                // se fusionan
                int min = Math.min (conju, conjv);
                int max = Math.max (conju, conjv);
                for (int k=0; k<n; k++)
                if (conjs[k]==max)
                    conjs[k] = min;
            }
        }
        imprimirArcos(orig, dest);
        return coste;
    }

    private static void imprimirArcos (int[] orig, int[] dest) {
        for (int i=0; i<orig.length; i++)
           System.out.println ("Arco "+i+": ("+orig[i]+","+dest[i]+")");
        System.out.println ();
    }
 
    

    public static void main(String[] args) {
        int[] us=new int[]{0,0,0,1,1,2,2,3},
              vs=new int[]{1,2,4,3,4,3,4,4},
              cs=new int[]{16,12,21,6,11,18,33,14};
        int n=5;
        System.out.println(Kruskal(us,vs,cs,n));
    }
}
