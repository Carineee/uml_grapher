package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {
    private final Set<UmlType> type;

    public MermaidFormatter(Set<UmlType> type){
        this.type = type;
    }

    public String MyString(){
        String line = "classDiagram\n";
        for(UmlType s: type){
            line +="class " + s.name();
            if(Modifier.isInterface(s.my_class().getModifiers())){
                line += " {\n    <<interface>>\n}";
            }
            line += "\n";
        }
        return line;
    }
}
