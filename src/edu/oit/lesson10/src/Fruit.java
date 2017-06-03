/**
 * Created by IT on 2017/5/16.
 */

public class Fruit {
    public static int count = 0;
    private int num = 0;

    public  int getNum(){
        return this.num;
    }

    public Fruit(){
        this.count +=1;
    }

    public static void count(){
        System.out.println(Fruit.count);
    }
}
