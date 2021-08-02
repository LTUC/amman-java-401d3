package demo;

// To inherit from a class, we add the keyword extends after the child class name, and follow it with the name of the class we are injeriting from
// Multiple inheritance isn't allowed in Java (a class cannot extend more than one class)
public class FirstChild extends ParentClass {

    // Every Class should have a constructor function, if we don't provide one, there will be a default one with no parameters
//    FirstChild(){
//        System.out.println("First Child Constructor");
//    }

    public int firstChildPublicint;
    protected int firstChilProtectedint;
    private int firstChilPrivateint;

    public FirstChild(int privateIntInsideParent) {
        super(privateIntInsideParent);
    }

    public int getFirstChildPublicint() {
        return firstChildPublicint;
    }

    public void setFirstChildPublicint(int firstChildPublicint) {
        this.firstChildPublicint = firstChildPublicint;
    }

    public int getFirstChilProtectedint() {
        return firstChilProtectedint;
    }

    public void setFirstChilProtectedint(int firstChilProtectedint) {
        this.firstChilProtectedint = firstChilProtectedint;
    }

    public int getFirstChilPrivateint() {
        return firstChilPrivateint;
    }

    public void setFirstChilPrivateint(int firstChilPrivateint) {
        this.firstChilPrivateint = firstChilPrivateint;
    }

    public void mehotdExistsOnlyInFirstChild(){
        System.out.println("This is a first child method");
    }

    @Override
    public void printHello() {
        System.out.println("The method in child");
        super.printHello();
    }
}
