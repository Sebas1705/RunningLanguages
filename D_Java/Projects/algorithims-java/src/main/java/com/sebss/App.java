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
        HashOpenArray<Integer> hash = new HashOpenArray<>();
        // for(int i=0;i<10;i+=(int)(Math.random()*5+1))hash.add(i);
        hash.add(10);
        hash.printAsArray();
    }
}
