package Shapes;

public class Square extends Circle{

    public Square(double sideLength, String name, String color){
        super(name, color,5);
        this.sideLength = sideLength;
    }

    private double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }


    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }
}
