package com.sebss;

import com.sebss.DataStructures.Hashs.HashOpens.HashOpenArray;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HashOpenArray<Integer> hash = new HashOpenArray<>(2);
        for(int i=0;i<100;i+=(int)(Math.random()*5+1))hash.add(i);
        hash.printAsArray();
    }
}
