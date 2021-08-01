package demo;

public class Point {

    //encapsulation : having all class fields as private, and providing public setters and getters for them
    private int x;
    private int y;

    // having 2 methods with the same name but different signatures in the same class is called Overloading
    public Point(){
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // setters and getters
    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
