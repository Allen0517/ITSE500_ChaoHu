/**
 * Created by IT on 2017/5/30.
 */
public class Product {
    public static String name;
    public static String inventory;
    public static int code;
    public static double weight;
    public static double price;

    public Product(String name, String inventory, int code, double wieght, double price){
        this.name = name;
        this.inventory = inventory;
        this.code = code;
        this.weight = weight;
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getInventory(){
        return this.inventory;
    }
    public int getCode(){
        return this.code;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getprice(){
        return this.price;
    }
}
