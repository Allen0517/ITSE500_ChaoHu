/**
 * Created by IT on 2017/5/8.
 */

public class Circle {
    private float radius;

    public Circle(float radius){
        this.radius = radius;
    }

    public float getRadius(){
        return radius;
    }

    public void setRadius(float radius){
        this.radius = radius;
    }

    private double calculateArea(){
        return radius*radius*Math.PI;
    }

    public double area(){
        return calculateArea();
    }
}
