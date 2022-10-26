package fr.lernejo.umlgrapher;

public class MermaidLiaison {

    private final String ChildrenClass;
    private final String ParentClass;
    private final String liaison;

    public MermaidLiaison(Class ParentClass,Class ChildClass,String liaison){
        this.ChildrenClass = ChildClass.getSimpleName();
        this.ParentClass = ParentClass.getSimpleName();
        this.liaison = liaison;
    }

    public String getChildClass(){
        return this.ChildrenClass;
    }

    public String getParentClass(){
        return this.ParentClass;
    }
    public String getLiaison(){
        return this.liaison;
    }
}
