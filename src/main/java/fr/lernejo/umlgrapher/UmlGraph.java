package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class[] Cname;

    public UmlGraph(Class[] Cname){
        this.Cname = Cname;
    }

    public String as (GraphType dimension){
        String answer = "classDiagram";

        for (Class myClass : Cname){
            if (dimension == GraphType.Mermaid) {
                answer +="class" + myClass.getSimpleName() + "{\n";
                if (myClass.isInterface()){
                    answer += "<<interface\n";
                }
                answer += "}\n";
            }
        }
        return answer;}
}
