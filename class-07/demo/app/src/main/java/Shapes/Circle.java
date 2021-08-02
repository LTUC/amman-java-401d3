package Shapes;

public class Circle extends Shape{

    /*
    by default, we have the constructor:
    public Circle(){
        super();
    }
     */

//    public Circle(){
//        super("first circle","White");
//    }

//    public Circle(String name, String color, double radius){
//        super(name,color);
//        this.radius = radius;
//    }


    public Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        // whatever I do to calculate the circle area
        double area = 0;
        return area;
    }
}
