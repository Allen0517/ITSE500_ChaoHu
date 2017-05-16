/**
 * Created by IT on 2017/5/15.
 */
public class Taobao {

    private String[] name;
    private double price;
    private int number;
    public static int amount;
    public static double total;




    public class Product{
        public String productName;
        public double productPrice;
        public double productNumber;

        public Product(String name, double price, int number){
            this.productName = name;
            this.productNumber = number;
            this.productPrice = price;
        }


    }




}
