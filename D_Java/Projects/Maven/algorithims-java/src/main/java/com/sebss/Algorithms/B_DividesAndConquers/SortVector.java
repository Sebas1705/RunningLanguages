package com.sebss.Algorithms.B_DividesAndConquers;

import java.util.Arrays;

public class SortVector {
    
    public static void sort(int[] vector){
        sortAlgorithm(vector,0,vector.length);
    }

    private static void sortAlgorithm(int[] vector,int start,int end){
        if (start<end) {
            int mid = start+(end-start)/2;
            sortAlgorithm(vector,start,mid);
            sortAlgorithm(vector,mid+1,end);
            merge(vector,start,mid,end);
        }
    }


    private static void merge(int[] vector, int left, int middle, int right) {
        int n1 = middle-left+1;
        int n2 = right-middle;
        int[] vectorL = Arrays.copyOfRange(vector,left,left+n1);
        int[] vectorR = Arrays.copyOfRange(vector,middle+1,middle+1+n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (vectorL[i]<=vectorR[j]) vector[k++] = vectorL[i++];  
            else vector[k++] = vectorR[j++];
        }
        while (i < n1) vector[k++] = vectorL[i++];
        while (j < n2) vector[k++] = vectorR[j++];
    }
}
