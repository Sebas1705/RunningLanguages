package com.sebss.DataStructures.Lists.UsesList.PriorityList;

import com.sebss.DataStructures.Lists.ListS;
import com.sebss.DataStructures.Lists.Array_List.Array_List;

public class PriorityArray<T> extends PriorityList<T>{

    //Constructors:
    public PriorityArray(){
        pList=new Array_List<PriorityObject<T>>();
    }
    @SuppressWarnings("unchecked")
    public PriorityArray(T ...e){
        this();
        for(T x : e) add(x,0);
    }
    //End of constructors.

    //Override:
    @Override
    public ListS<T> subList(int fi, int ti) {
        ListS<T> temp = new Array_List<>();
        for(int i=fi;i<=ti;i++)temp.add(pList.get(i).getObject());
        return temp;
    }
    @Override
    public void printAsArray() {
        String s ="PriorityArray: {";
        if(pList.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?pList.get(i)+"|":pList.get(i);
        else s+="Empty";
        s+="} size("+size()+")"; 
        System.out.println(s);
    }
    @Override
    public String toString() {
        String s = "->PriorityArray("+size()+"):\n{";
        if(pList.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?pList.get(i)+"|":pList.get(i);
        else s+="Empty\n";
        s+="}\n->End of PriorityArray.\n";
        return s;
    }
    
}
