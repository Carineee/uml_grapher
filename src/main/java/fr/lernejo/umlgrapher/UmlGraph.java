package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class[] Cname;

    public UmlGraph(Class[] Cname){
        this.Cname = Cname;
    }

    public String as (GraphType graphType){
        String answer = "classDiagram";

        for (Class<?> myClass : Cname){
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
