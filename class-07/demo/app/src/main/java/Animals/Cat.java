package Animals;

public class Cat extends Pet {
    @Override
    public void eat() {
        System.out.println("This is a cat eating");
    }

    @Override
    public void sleep() {
        System.out.println("This is a cat sleeping");
    }

    @Override
    public void walk() {
        System.out.println("This is a cat walking");
    }


    public void catSpecificMethod(){
        System.out.println("CAT ONLY");
    }
}
