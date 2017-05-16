/**
 * Created by IT on 2017/5/15.
 */
public class Taobao {

    private String[] name;
    private double price;
    private int number;
    public static int amount = 0;
    public static double total = 0;


    public class Product{
        public String productName;
        public double productPrice;
        public int productNumber;

        public Product(String name, double price, int number){
            this.productName = name;
            this.productNumber = number;
            this.productPrice = price;
        }
    }
    public void addToCart(Product product){
        Taobao.amount = product.productNumber +Taobao.amount;
        Taobao.total = product.productNumber*product.productPrice +Taobao.total;
    }

    public int getAmount(){
        return amount;
    }
    public double getTotal(){
        return total;
    }

    public static void main(String[] args){
        Taobao taobao = new Taobao();
        Taobao.Product book = taobao.new Product("Book",10,3);
        Taobao.Product water = taobao.new Product("water",1,3);
        Taobao.Product meat = taobao.new Product("meat",20,3);
        taobao.addToCart(book);
        taobao.addToCart(water);
        taobao.addToCart(meat);
        System.out.println(taobao.getAmount());
        System.out.println(taobao.getTotal());

    }

}
