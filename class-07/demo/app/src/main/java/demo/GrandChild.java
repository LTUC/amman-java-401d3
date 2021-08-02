package demo;

public class GrandChild extends FirstChild{
    private int grandChildInt;

    public GrandChild(int privateIntInsideParent) {
        super(privateIntInsideParent);
    }

    public int getGrandChildInt() {
        return grandChildInt;
    }

    public void setGrandChildInt(int grandChildInt) {
        this.grandChildInt = grandChildInt;
    }

    @Override
    public void printHello() {
        System.out.println("implementation in grandchild");
        super.printHello();
    }

    @Override
    public void mehotdExistsOnlyInFirstChild() {
        System.out.println("overriden methd from inside grandchild");
        super.mehotdExistsOnlyInFirstChild();
    }
}
