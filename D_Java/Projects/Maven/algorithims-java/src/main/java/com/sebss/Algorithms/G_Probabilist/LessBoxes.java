package com.sebss.Algorithms.G_Probabilist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class LessBoxes {


   public static void main(String[] args) {
      int[] ps=new int[]{5,2,4,1,8};
      System.out.println("Iter  : "+menosCajasIter(ps,10));
      System.out.println("Prob  : "+menosCajasProb(ps,10));
      System.out.println("Aprox1: "+menosCajasAprox1(ps,10));
      System.out.println("Aprox2: "+menosCajasAprox2(ps,10));
      System.out.println("Back  : "+menosCajasBack(ps,10));
      System.out.println("RyP   : "+menosCajasRyP(ps,10));
   }

   public static int menosCajasIter(int[] ps,int c){
      int minValue=Integer.MAX_VALUE;
      for(int i=0;i<10;i++){
         int value=menosCajasProb(ps,c);
         if(value<minValue) minValue=value;
      }
      return minValue;
   }

   public static int menosCajasProb (int[] ps, int c){
      Random rand = new Random();
      Map<Integer,Integer> cajasMap = new HashMap<Integer,Integer>();
      for(int i=0;i<ps.length;i++){
         final int index=i;
         List<Integer> cajasFiltradas=cajasMap.entrySet().stream()
                .filter(entry->entry.getValue()-ps[index]>=0)
                .map(Entry::getKey)
                .collect(Collectors.toList());

         int caja=rand.nextInt(cajasFiltradas.size()+1);
         if(caja==cajasFiltradas.size()) cajasMap.put(cajasMap.size(),c-ps[i]);
         else {
            caja=cajasFiltradas.get(caja);
            cajasMap.put(caja,cajasMap.get(caja)-ps[i]);
         }
      }
      return cajasMap.size();
   }


   


   public static int menosCajasBack (int[] ps, int c) {
      int[] libre = new int[ps.length];
      libre[0] = c-ps[0];
      for (int i=1; i<ps.length; i++)
         libre[i] = c;
      int[] cajas = new int[ps.length];
      cajas[0] = 0;
      int[] libreOpt = new int[ps.length];
      int[] cajasOpt = new int[ps.length];
      int num = buscarCajas (ps, c, 1, 0, libre, cajas, ps.length, libreOpt, cajasOpt);
      return num+1;
   }
     
   private static int buscarCajas (int[] ps,int c,int i,int n,int[] libre,int[] cajas,int nOpt,int[] libreOpt,int[] cajasOpt) {
      for (int j=0; j<=n+1; j++){
         if (ps[i]<=libre[j]) {
            cajas[i] = j; 
            libre[j] -= ps[i];
            int nn = Math.max(n,j);
            if (i==ps.length-1) {
               if (n<nOpt) {
                  nOpt = nn;
                  for (int k=0; k<nn; k++)
                     libreOpt[k] = libre[k];
                  for (int k=0; k<ps.length; k++)
                     cajasOpt[k] = cajas[k];
               }
            } else nOpt = buscarCajas (ps, c, i+1, nn, libre, cajas, nOpt, libreOpt, cajasOpt);
            libre[j] += ps[i];
         }
      }
      return nOpt;
   }

   public static int menosCajasAprox1 (int[] ps, int c) {
      // heurística 'next fit'
      int[] is = new int[ps.length];
      is = ordenarIndicesCrec (ps);
      // cajas[i] contiene el índice del último objeto introducido en la caja i
      int[] cajas = new int[ps.length];
      // empezamos con 1 caja, pero lo inicializamos en uno menos para indexar arrays
      int num = 0;
      int p = c;
      for (int i=0; i<ps.length; i++) {
         if (ps[is[i]]<=p)
            p -= ps[is[i]];
         else {
            num++;
            p = c-ps[is[i]];
         }
         cajas[num] = i;
      }
      return num+1;
   }
  
   private static int[] ordenarIndicesCrec (int[] v1) {
      // se ordena por inserción directa
      int[] v2 = new int[v1.length];
      v2[0] = 0;
      for (int i=1; i<v1.length; i++) {
         int aux = v1[i];
         int j;
         for (j=i-1; j>=0 && v1[v2[j]]>aux; j--)
            v2[j+1] = v2[j];
         v2[j+1] = i;
      }
      return v2;
   }
  
   public static int menosCajasAprox2 (int[] ps, int c) {
      // heurística 'first fit decreasing'
      int[] is = new int[ps.length];
      is = ordenarIndicesDecrec (ps);
      // libre[i] contiene el peso que hay libre en la caja i
      int[] libre = new int[ps.length];
      libre[0] = c-ps[is[0]];
      //cajas[i] contiene el número de caja donde se mete el objeto i
      int[] cajas = new int[ps.length];
      cajas[0] = 0;
      int num = 0;
      for (int i=1; i<ps.length; i++) {
         boolean metido = false;
         for (int j=0; (j<=num) && !metido; j++) {
            if (ps[is[i]]<=libre[j]) {
               cajas[is[i]] = j;
               metido = true;
               libre[j] -= ps[is[i]];
            }
         }
         if (!metido) {
            num++;
            cajas[is[i]] = num;
            libre[num] = c-ps[is[i]];
         }
      }
      return num+1;
   }
  
   private static int[] ordenarIndicesDecrec (int[] v1) {
      // se ordena por inserción directa
      int[] v2 = new int[v1.length];
      v2[0] = 0;
      for (int i=1; i<v1.length; i++) {
         int aux = v1[i];
         int j;
         for (j=i-1; j>=0 && v1[v2[j]]<aux; j--)
            v2[j+1] = v2[j];
         v2[j+1] = i;
      }
      return v2;
   }

   static int nodos;
   public static int menosCajasRyP (int[] ps, int c) {
      nodos = 0;
      int[] libre = new int[ps.length];
      libre[0] = c-ps[0];
      for (int i=1; i<ps.length; i++)
         libre[i] = c;
      int[] donde = new int[ps.length];
      donde[0] = 0;
      int restante = c - ps[0];
      int[] dondeOpt = new int[ps.length];
      // cota como suma de cajas usadas más promedio de cajas necesarias para el resto de objetos
      int[] psAcum = new int[ps.length];
      psAcum[psAcum.length-1] = ps[ps.length-1];
      for (int i=ps.length-2; i>=0; i--)
         psAcum[i] = ps[i]+psAcum[i+1];
      int cota = (int) Math.ceil((float)(psAcum[0])/(float)c);
      int num = buscarCajasRyP (ps, c, 1, libre, psAcum, 0, restante, donde, ps.length, dondeOpt);
      return num+1;
   }
     
   private static int buscarCajasRyP (int[] ps,int c,int i,int[] libre,int[] psAcum,int n,int restante,int[] donde,int nOpt,int[] dondeOpt) {
      // versión basada en el esquema de la técnica de ramificación y poda
      for (int j=0; j<=n+1; j++){
         if (ps[i]<=libre[j]) {
            donde[i] = j;
            libre[j] -= ps[i];
            int nn;
            if (j!=n+1) {
               nn = n;
               restante -= ps[i];
            } else {
               nn = n+1;
               restante += c-ps[i];
            }
            int nuevaCota = nn + ((i==ps.length-1)?0:(int)Math.ceil((float)(psAcum[i+1]-restante)/(float)c));
            if (nuevaCota<nOpt+1) {
               nodos++;
               if (i==ps.length-1) {
                  if (nn<nOpt) {
                     nOpt = nn;
                     for (int k=0; k<ps.length; k++)
                        dondeOpt[k] = donde[k];
                  }
               } else nOpt = buscarCajasRyP (ps, c, i+1, libre, psAcum, nn, restante, donde, nOpt, dondeOpt);
            }
            libre [j] += ps[i];
         }
      }
      return nOpt;
   }
}
