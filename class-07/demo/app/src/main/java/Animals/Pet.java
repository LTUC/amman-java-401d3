package Animals;

public class Pet implements Animal {

    @Override
    public void eat() {
        System.out.println("This is a pet eating");
    }

    @Override
    public void sleep() {
        System.out.println("This is a pet sleeping");
    }

    @Override
    public void walk() {
        System.out.println("This is a pet walking");
    }

    public void petSpecificMethod(){
        System.out.println("PET ONLY");
    }
}
