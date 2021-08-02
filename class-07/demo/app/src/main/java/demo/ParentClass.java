package demo;
// Object
public class ParentClass {

    public ParentClass(){
        System.out.println("Parent class constructor");
    }

    public ParentClass(int privateIntInsideParent){
        System.out.println("Parent class non default constructor");
        this.privateIntInsideParent = privateIntInsideParent;
    }

    // Having private fields and providing public setters and getters -> Encapsulation
    private int privateIntInsideParent;
    protected int protectedIntInsideParent;
    public int publicIntInsideParent;

    public int getPrivateIntInsideParent() {
        return privateIntInsideParent;
    }

    public void setPrivateIntInsideParent(int privateIntInsideParent) {
        this.privateIntInsideParent = privateIntInsideParent;
    }

    public int getProtectedIntInsideParent() {
        return protectedIntInsideParent;
    }

    public void setProtectedIntInsideParent(int protectedIntInsideParent) {
        this.protectedIntInsideParent = protectedIntInsideParent;
    }

    public int getPublicIntInsideParent() {
        return publicIntInsideParent;
    }

    public void setPublicIntInsideParent(int publicIntInsideParent) {
        this.publicIntInsideParent = publicIntInsideParent;
    }

    public void printHello(){
        System.out.println("Hello from parent class");
    }

    @Override
    public String toString() {
        return "ParentClass{" +
                "privateIntInsideParent=" + privateIntInsideParent +
                ", protectedIntInsideParent=" + protectedIntInsideParent +
                ", publicIntInsideParent=" + publicIntInsideParent +
                '}';
    }
}
