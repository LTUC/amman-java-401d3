package Animals;

public class Dog extends Pet {
    @Override
    public void eat() {
        System.out.println("This is a dog eating");
    }

    @Override
    public void sleep() {
        System.out.println("This is a dog sleeping");
    }

    @Override
    public void walk() {
        System.out.println("This is a dog walking");
    }

    public void dogSpecificMethod(){
        System.out.println("Dog ONLY");
    }
}
