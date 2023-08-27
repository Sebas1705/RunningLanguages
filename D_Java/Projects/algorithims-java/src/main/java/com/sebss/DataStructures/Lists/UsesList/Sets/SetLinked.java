package com.sebss.DataStructures.Lists.UsesList.Sets;

import com.sebss.DataStructures.Interfaces.CollectionS;
import com.sebss.DataStructures.Lists.Linked_List.SimpleLinked_List;

public class SetLinked<T> extends SetList<T> {

    //Constructors:
    public SetLinked(){
        set=new SimpleLinked_List<T>();
    }
    public SetLinked(CollectionS<T> c){
        set=new SimpleLinked_List<T>(c);
    }
    @SuppressWarnings("unchecked")
    public SetLinked(T ...e){
        set=new SimpleLinked_List<T>(e);
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
