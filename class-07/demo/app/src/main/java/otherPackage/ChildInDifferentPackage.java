package otherPackage;

import demo.ParentClass;

public class ChildInDifferentPackage extends ParentClass {

    public int anotherChildVar;

    public int getAnotherChildVar() {
        return anotherChildVar;
    }

    public void setAnotherChildVar(int anotherChildVar) {
        this.anotherChildVar = anotherChildVar;
    }
}
