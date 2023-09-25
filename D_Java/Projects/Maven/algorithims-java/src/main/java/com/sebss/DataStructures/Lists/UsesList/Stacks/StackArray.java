package com.sebss.DataStructures.Lists.UsesList.Stacks;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Array_List.Array_List;

public class StackArray<T> extends StackList<T>{

    //Constuctors:
    public StackArray(){
        stack=new Array_List<>();
    }
    @SuppressWarnings("unchecked")
    public StackArray(T ...e){
        this();
        for(T x : e) push(x);
    }
    public StackArray(CollectionS<T> c){
        stack=new Array_List<T>(c);
    }
    //End of Constuctors.
    
    //Overrides:
    @Override
    public String toString(){
        String s = "->StackArray("+size()+"):\n{";
        if(stack.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?stack.get(i)+"|":stack.get(i);
        else s+="Empty\n";
        s+="}\n->End of StackArray.\n";
        return s;
    }
    public void printAsArray(){
        String s ="StackArray: {";
        if(stack.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?stack.get(i)+"|":stack.get(i);
        else s+="Empty";
        s+="} size("+size()+")"; 
        System.out.println(s);
    }
    //End of Overrides.

}
