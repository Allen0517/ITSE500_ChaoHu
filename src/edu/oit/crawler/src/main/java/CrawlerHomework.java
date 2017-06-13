import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.beans.binding.ObjectExpression;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.*;
import org.jsoup.nodes.Document;
import org.json.*;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import com.google.gson.Gson;

import static org.apache.commons.lang3.StringEscapeUtils.escapeJson;

/**
 * Created by IT on 2017/5/30.
 */
public class CrawlerHomework {

    public static final String URL_TOOT ="https://www.walmart.com/search/?cat_id=0&grid=true&page=";

    public static void main(String[] args) {
        Document doc = null;
        File file;
        File linkFile = null;
        File fileImage;
        try{
            file = new File("Walmart");
            fileImage = new File("Image");
            linkFile = new File(file, "result.txt");
        }catch(NullPointerException e){
            e.printStackTrace();
        }



    for(int j = 1; j<=16; j++){
        String URL = URL_TOOT + j +"&query=xps#searchProductResult";
        try{
            Connection.Response res = Jsoup.connect(URL)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(10000).ignoreContentType(true).execute();//.get();

            Document doc1 = res.parse();
            Element script = doc1.select("script").get(10);
            String jsonStr = script.data().substring(37);

            for(int i = 1; i <= 20; i++){
                String temp = jsonStr;
//            System.out.println(temp.split("(\"productId\")")[1]);

                String  product = "{\"productId\"" + temp.split("(\"productId\")")[i];
//           String title = product.split("\"title\":(.*)(,\"description\")")[1];

                Pattern pat = Pattern.compile("\"title\":(.*)(,\"description\")");
                Matcher mat = pat.matcher(product);
                String title = "";
                while(mat.find()){
                    title = mat.group(1).toString();
                }
                Pattern patImage = Pattern.compile("\"imageUrl\":(.*)(,\"productPageUrl\")");
                Matcher matImage = patImage.matcher(product);
                String imageUrl = "";
                while(matImage.find()){
                    imageUrl = matImage.group(1).toString();
                }

                Pattern patType = Pattern.compile("\"productType\":(.*)(,\"title\")");
                Matcher matType = patType.matcher(product);
                String type = "";
                while(matType.find()){
                    type = matType.group(1).toString();
                }

                Pattern patPrice = Pattern.compile("\"offerPrice\":(.*)(,\"currencyCode\")");
                Matcher matPrice = patPrice.matcher(product);
                String price = "";
                while(matPrice.find()){
                    price = matPrice.group(1).toString();
                }

                Pattern patImageId = Pattern.compile("\"usItemId\":(.*)(,\"productType\")");
                Matcher matImageId = patImageId.matcher(product);
                String imageId = "";
                while(matImageId.find()){
                    imageId = matImageId.group(1).toString();
                }
// save text;
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(linkFile, true))) {
                    bw.write(title);
                    bw.write(imageUrl);
                    bw.write(type);
                    bw.write(price);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//save image
                BufferedImage image = null;
                try {
                    URL url = new URL(imageUrl.substring(1,imageUrl.length()-1));
                    image = ImageIO.read(url);
                    ImageIO.write(image, "jpg",new File("Walmart\\Image\\"+imageId.substring(1,imageId.length()-1)+".jpg"));

                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(title);
                System.out.println(imageUrl);
                System.out.println(type);
                System.out.println(price);
            }

//            Gson gson = new Gson();
//            String str = gson.fromJson(product, String.class);
//            try{
//                JsonObject object = Json.parse(gson).asObject();
//                String name = object.get("name").asString();
//            System.out.println(newJSON.toString());
//
//        }catch (JSONException e){
//            System.out.println(e);
//        }

//            Gson gson = new Gson();
//            Object str = gson.fromJson(jsonStr, String.class);
//            System.out.println(str.toString());

//            System.out.println(matcher.toString());


//            Gson obj = new Gson(script.data())
//            System.out.println(products.size());

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
}





























