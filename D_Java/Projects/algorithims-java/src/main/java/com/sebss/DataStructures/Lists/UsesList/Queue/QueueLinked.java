package com.sebss.DataStructures.Lists.UsesList.Queue;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.SimpleLinked_List;

public class QueueLinked<T> extends QueueList<T> {
    
    //Constuctors:
    public QueueLinked(){
        queue=new SimpleLinked_List<>();
    }
    @SuppressWarnings("unchecked")
    public QueueLinked(T ...e){
        this();
        for(T x : e) push(x);
    }
    public QueueLinked(CollectionS<T> c){
        queue=new SimpleLinked_List<T>(c);
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
    public void printAsArray(){
        String s ="QueueArray: {";
        if(queue.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?queue.get(i)+"|":queue.get(i);
        else s+="Empty";
        s+="} size("+size()+")"; 
        System.out.println(s);
    }
    //End of Overrides.
}
