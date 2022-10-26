package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {
    private final Class myclass;
    InternalGraphRepresentation(Class myclass){
        this.myclass = myclass;
    }

    public List<Class> recursive_relation(List<Class> recursiveList,Class... otherClasses){
        for(Class i : otherClasses){
            if(!recursiveList.contains(i)) {
                recursiveList.add(i);
                recursiveList = recursive_relation(recursiveList,i.getInterfaces());
            }
        }
        return recursiveList;
    }
    public List<Class> whats_your_relation(){
        List<Class> myList = new ArrayList<Class>();
        myList = recursive_relation(myList,this.myclass);
        return myList;
    }
}
