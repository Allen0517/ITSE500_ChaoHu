/**
 * Created by IT on 2017/5/14.
 */
public class Vehicle {
    public String name;
    private int speed;
    private double size;

    public Vehicle(String name,int speed, double zise){
        this.name = name;
        this.speed = speed;
        this.size = size;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void move(){
        System.out.println(this.name+" is moving with the speed "+this.speed);
    }

    public void speedUp(int addSpeed){
        this.speed += addSpeed;
    }
    public void speedDown(int subscribeSpeed){
        this.speed -= subscribeSpeed;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Car", 50,1000);
        Vehicle v2 = new Vehicle("Bike", 24,1000);
        v1.move();
        v1.speedUp(20);
        v1.move();
        v1.speedDown(40);
        v1.move();
    }


/*   the result:
    Car is moving with the speed 50
    Car is moving with the speed 70
    Car is moving with the speed 30
    */

}
