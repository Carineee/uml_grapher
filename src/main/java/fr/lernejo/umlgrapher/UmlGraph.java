package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;

public class UmlGraph {

    private final Class<?>[] classes;

    public UmlGraph(Class<?>[] classes) {
        this.classes = classes;
    }

    public String as(GraphType graphType) {

        if (graphType == GraphType.Mermaid) {
            String answer = "graph";

            for (Class<?> myClass : classes) {
                boolean isInterface = Modifier.isInterface(myClass.getModifiers());
                answer += "\nclass %s %s".formatted(
                    myClass.getSimpleName(),
                    isInterface ? "{\n    <<interface>>\n}\n" : "\n");
            }
            return answer;
        }
        return "graph";
    }
}

