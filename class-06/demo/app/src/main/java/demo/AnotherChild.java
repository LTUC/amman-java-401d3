package demo;

public class AnotherChild extends ParentClass {

    private int theOtherChildInt;

    public int getTheOtherChildInt() {
        return theOtherChildInt;
    }

    public void setTheOtherChildInt(int theOtherChildInt) {
        this.theOtherChildInt = theOtherChildInt;
    }

    @Override // annotation that indicates overriding a method in a parent class
    public void printHello() {
        System.out.println("Print Hello from another child");
        super.printHello();
    }
}
