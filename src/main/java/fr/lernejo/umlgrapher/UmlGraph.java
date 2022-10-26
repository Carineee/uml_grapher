package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class<?>[] classes;

    public UmlGraph(Class<?>[] classes){
        this.classes = classes;
    }

    public String as (GraphType graphType){
        String answer = "classDiagram";

        for (Class<?> myClass : classes){
            if (graphType == GraphType.Mermaid) {
                answer += "class" + myClass.getSimpleName() + "{\n";
                if (myClass.isInterface()){
                    answer += "<<interface\n";
                }
                answer += "}\n";
            }
        }
        return answer;}
}
