package com.sebss.DataStructures.Lists.UsesList.PriorityList;

public class PriorityObject<T> {
    
    //Atributtes:
    private T object;
    private int priorityGrade;
    //End of atributtes.

    //Constructor:
    public PriorityObject(T object, int priorityGrade){
        this.object = object;
        this.priorityGrade = priorityGrade;
    }
    //End of constructor.

    //Publics:
    /**
     * @return 1> if this has higher priority,
     *         0 if there have the same priority and
     *        -1< if p has higher priority
    */
    public int compare(PriorityObject<T> p){
        return priorityGrade-p.getPriorityGrade();
    }
    //End of publics.

    //Getters:
    public T getObject() {return object;}
    public int getPriorityGrade() {return priorityGrade;}
    //End of getters.

    //Overrides:
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o){
        if(o instanceof PriorityObject){
            PriorityObject<T> that = (PriorityObject<T>) o;
            if(priorityGrade==that.getPriorityGrade()&&
            object.equals(that.getObject())) return true;
        }
        return false;
    }
    //End of overrides.
}
