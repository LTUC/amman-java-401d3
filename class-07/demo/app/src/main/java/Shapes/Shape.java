package Shapes;

// abstract classes cannot be instantiated (I cannot create objects from this type)
public abstract class Shape {

    /* If I don't create a constructor, then the class has a default constructor
    public Shape(){
        super();
    }
     */

    // creating non-default constructor
    public Shape(String name, String color){
        this.name = name;
        this.color = color;
    }

    private String name;
    private String color;
    private double area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // abstract methods don't have body (implementation)
    // this means, any class that extend my class, should provide it's own implementation for the method
    public abstract double calculateArea();
}
