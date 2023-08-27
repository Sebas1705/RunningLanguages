package com.sebss.DataStructures.Lists.UsesList.Stacks;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.SimpleLinked_List;

public class StackLinked<T> extends StackList<T>{
    
    //Constuctors:
    public StackLinked(){
        stack=new SimpleLinked_List<>();
    }
    @SuppressWarnings("unchecked")
    public StackLinked(T ...e){
        this();
        for(T x : e) push(x);
    }
    public StackLinked(CollectionS<T> c){
        stack=new SimpleLinked_List<T>(c);
    }
    //End of Constuctors.
    
    //Overrides:
    @Override
    public String toString(){
        String s = "->StackLinked("+size()+"):\n{";
        if(stack.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?stack.get(i)+"|":stack.get(i);
        else s+="Empty\n";
        s+="}\n->End of StackLinked.\n";
        return s;
    }
    public void printAsArray(){
        String s ="StackLinked: {";
        if(stack.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?stack.get(i)+"|":stack.get(i);
        else s+="Empty";
        s+="} size("+size()+")"; 
        System.out.println(s);
    }
    //End of Overrides.
}
