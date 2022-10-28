package fr.lernejo.umlgrapher;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import java.util.concurrent.Callable;

public class UmlType {

    private final String name;
    private final String PackageName;
    UmlType( Class classes)
    {
        this.name = classes.getSimpleName();
        this.PackageName = classes.getPackageName();
    }

    public String name(){
        return this.name();
    }

    public String PackageName(){
        return this.PackageName();
    }

    private final Set<Class> types = new TreeSet<>(Comparator
        .<Class, String>comparing(Class::getSimpleName)
        .thenComparing(Class::getPackageName));

    public UmlType(Class[] classes){
        this.getClass (classes);
    }

    private void getClass(Class[] classes) {
        for (Class c : classes) {
            recursionSearch(c);
        }
    }

    private void getChildren(Class cl) {
        Reflections reflections;
        try {
            reflections = new Reflections(new ConfigurationBuilder().forPackage("")
                .forPackage("", cl.getClassLoader())
            );
        } catch (RuntimeException e) {
            System.out.println("Missing loader class");
            return;
        }
        Set<Class<?>> subTypes = reflections.get(
            Scanners.SubTypes.get(cl).asClass(this.getClass().getClassLoader(), cl.getClassLoader())
        );
        for (Class classes : subTypes) {
            getChildren(classes);
            if (!types.contains(classes)) types.add(classes);
        }
    }

    private void recursionSearch(Class cl) {
        Class superClass = cl.getSuperclass();
        if (superClass != null
            && !superClass.getSimpleName().equals("Object"))
            recursionSearch(superClass);

        for (Class inter : cl.getInterfaces()) {
            recursionSearch(inter);
        }

        types.getChildren(cl);
    types.add(cl);
}
    public Set<Class> getListClass(){
    return this.types;
    }
}
