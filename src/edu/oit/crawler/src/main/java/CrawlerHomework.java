import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
/**
 * Created by IT on 2017/5/30.
 */
public class CrawlerHomework {
    public static final String URL_TOOT = "https://www.walmart.com/search/?cat_id=0&grid=true&page=1&query=xps#searchProductResult";


    public static void main(String[] args) {
        Document doc = null;
        try{
            Document doc1 = Jsoup.connect(URL_TOOT)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .get();
            doc = Jsoup.connect(URL_TOOT).get();

            Elements products = doc1.select(".search-result-gridview-items .Grid-col");
            System.out.println(products.size());


//            for(Element product : products){
//                String name = product.select(".product-name a").text();
//                String inventory = product.select(".product-inventory").text();
//                int code = Integer.parseInt(product.select(".product-code").text());
//                double weight = Double.parseDouble(product.select(".product-weight").text());
//                double price = Double.parseDouble(product.select(".product-price span.bold").text());
//                Product product1 = new Product(name, inventory, code, weight, price);
//
//            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}





























