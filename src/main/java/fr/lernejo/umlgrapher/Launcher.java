package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "Launcher", mixinStandardHelpOptions = true, version = "uml graph 1.0", description = "uml graph")
public class Launcher implements Callable<Integer> {

    @Option(names = {"-c", "--classes"}, required = true, description = "Select the class to analyse")
    private final Class[] classes = null;

    @Option(names = {"-g", "--graph-type"}, defaultValue = "Mermaid", description = "Select type of graph that you want in the output")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public Integer call() throws Exception {
        UmlGraph graph = new UmlGraph(classes);
        System.out.println(graph.as(GraphType.valueOf(String.valueOf(graphType))));
        return null;
    }

    public static void main(String... args) {
         int exitCode = new CommandLine(new Launcher()).execute(args);
            System.exit(exitCode);
    }
}
