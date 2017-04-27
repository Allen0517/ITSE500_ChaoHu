import com.sun.org.apache.regexp.internal.RE;
import sun.security.provider.SHA;

/**
 * Created by IT on 2017/4/27.
 */
public class Shapes {
    public int sideNumber;


    public static void main(String[] args) {
        Square square1 = new Square(10);
        System.out.println("square area is "+square1.area());

        Rectangle rectangle1 = new Rectangle(10,20);
        System.out.println("rectangle area is "+rectangle1.area());

        Circle circle1 = new Circle(5);
        System.out.println("circle area is "+circle1.area());
    }
}

class Square extends Shapes{
    private int sides = 4;
    private float width;

    public Square(float width){
        this.width = width;
    }
    public int getSides(){
        return sides;
    }
    public void setWidth(float width){
        this.width = width;
    }
    public float getWidth(){
        return width;
    }

    public double area(){
        return width*width;
    }
}

class Rectangle extends Shapes{
    private int sides = 4;
    private float length;
    private float width;

    public int getSides(){
        return sides;
    }
    public void setWidth(float width){
        this.width = width;
    }
    public float getWidth(){
        return width;
    }
    public void setLength(float length){
        this.length = length;
    }
    public float getLength(){
        return length;
    }

    public Rectangle(float width, float length){
        this.width = width;
        this.length = length;
    }

    public double area(){
        return width*length;
    }
}

class Circle extends Shapes{
    private float radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double area(){
        return radius * radius * Math.PI;
    }
}