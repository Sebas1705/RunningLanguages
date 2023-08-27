package com.sebss.DataStructures.Lists.UsesList.Queue;

import com.sebss.DataStructures.Interfaces.*;
import com.sebss.DataStructures.Lists.Array_List.Array_List;

public class QueueArray<T> extends QueueList<T> {

    //Constuctors:
    public QueueArray(){
        queue=new Array_List<>();
    }
    @SuppressWarnings("unchecked")
    public QueueArray(T ...e){
        this();
        for(T x : e) push(x);
    }
    public QueueArray(CollectionS<T> c){
        queue=new Array_List<T>(c);
    }
    //End of Constuctors.
    
    //Overrides:
    @Override
    public String toString(){
        String s = "->QueueArray("+size()+"):\n{";
        if(queue.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?queue.get(i)+"|":queue.get(i);
        else s+="Empty\n";
        s+="}\n->End of QueueArray.\n";
        return s;
    }
    @Override
    public void printAsArray(){
        String s ="QueueArray: {";
        if(queue.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?queue.get(i)+"|":queue.get(i);
        else s+="Empty";
        s+="} size("+size()+")"; 
        System.out.println(s);
    }
    //End of Overrides.

}
