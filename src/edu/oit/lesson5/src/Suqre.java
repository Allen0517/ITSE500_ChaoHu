/**
 * Created by IT on 2017/5/8.
 */
public class Suqre extends Shape {
    private int sides = 4;
    private int width;

    public Suqre(int width){
        this.width = width;
    }

    public int getWidth(){
        return width;
    }
    public void setWidth(int width){
        this.width = width;

    }

    public double getArea(){
        return calculateArea();
    }

    private int calculateArea(){
        return width*width;
    }
}
