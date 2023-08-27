package com.sebss.DataStructures.Lists.UsesList.Sets;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Array_List.Array_List;

public class SetArray<T> extends SetList<T> {

    //Constructors:
    public SetArray(){
        set=new Array_List<T>();
    }
    public SetArray(CollectionS<T> c){
        set=new Array_List<T>(c);
    }
    @SuppressWarnings("unchecked")
    public SetArray(T ...e){
        set=new Array_List<T>(e);
    }
    //End of constructors.

    //Overrides:
    @Override
    public void printAsArray() {
        String s ="SetArray: {";
        if(set.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?set.get(i)+"|":set.get(i);
        else s+="Empty";
        s+="} size("+size()+")"; 
        System.out.println(s);
    }
    @Override
    public String toString() {
        String s = "->SetArray("+size()+"):\n{";
        if(set.size()!=0) for(int i=0;i<size();i++)s+=(i!=size()-1)?set.get(i)+"|":set.get(i);
        else s+="Empty\n";
        s+="}\n->End of SetArray.\n";
        return s;
    }
    //End of Overrides.
}
