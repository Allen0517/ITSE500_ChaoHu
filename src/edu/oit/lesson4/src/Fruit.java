/**
 * Created by IT on 2017/4/26.
 */
public class Fruit {
    public String color;
    public int number;

    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }

    public void changecolor(){
    }

    public static int add(int[] args) {
        int result = 0;
        int len = args.length;

        for (int i = 0; i < len; i++) {
            result = result + args[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int total = 0;

        Apple apple = new Apple();
        Grape grape = new Grape();
        apple.setNumber(100);
        grape.setNumber(1000);
        apple.changecolor("red");

        int[] numberList = {apple.getNumber(),grape.getNumber()};

        total = add(numberList);

    }

}



class Apple extends Fruit{
    public String color = "green";
    public void changecolor(String color){
        this.color = color;
        System.out.println("The color is " + color + "now.");
    }
}

class Grape extends Fruit{

}