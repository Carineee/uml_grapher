package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {

    private final Class classInterGraph;
    InternalGraphRepresentation(Class classInterGraph){
        this.classInterGraph = classInterGraph;
    }

    public List<Class> recursive_relation(List<Class> recursiveList,Class... otherClasses){
        for(Class k : otherClasses){
            if(!recursiveList.contains(k)) {
                recursiveList.add(k);
                recursiveList = recursive_relation(recursiveList,k.getInterfaces());
            }
        }
        return recursiveList;
    }
    public List<Class> whats_your_relation(){
        List<Class> List = new ArrayList<Class>();
        List = recursive_relation(List,this.classInterGraph);
        return List;
    }
}
