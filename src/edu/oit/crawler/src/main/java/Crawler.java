import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
/**
 * Created by IT on 2017/5/30.
 */
public class Crawler {
    public static final String URL_TOOT = "http://www.nutrabio.com/category/herbal";


    public static void main(String[] args) {
        Document doc = null;
        try{
            doc = Jsoup.connect(URL_TOOT).get();
            Elements products = doc.select(".product-item");
            System.out.println(products.size());

            for(Element product : products){
                String name = product.select(".product-name a").text();
                String inventory = product.select(".product-inventory").text();
                int code = Integer.parseInt(product.select(".product-code").text());
                double weight = Double.parseDouble(product.select(".product-weight").text());
                double price = Double.parseDouble(product.select(".product-price span.bold").text());
                Product product1 = new Product(name, inventory, code, weight, price);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}




























