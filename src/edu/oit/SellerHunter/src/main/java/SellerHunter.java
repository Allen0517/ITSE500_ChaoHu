/**
 * Created by IT on 2017/6/6.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.ErrorHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SellerHunter {
    public static final String ROOTURL = "https://www.amazon.com/gp/offer-listing/";
    public static void main(String[] args) {

    FileReader fr = null;
    BufferedReader br = null;
    try {
        File file1 = new File("input");
        File linkFile = new File(file1, "products.txt");
        fr = new FileReader(linkFile);
        br = new BufferedReader(fr);
        String currentBook;
        while ((currentBook = br.readLine()) != null) {
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");

            WebDriver chromedriver = new ChromeDriver();
            String url = ROOTURL + currentBook;
            chromedriver.get(url);

            Book book = new Book(currentBook);
            List<Book.BookProduct> bookList = new ArrayList<Book.BookProduct>();
            book.addBookItemToList(bookList, book, chromedriver);
            String lastPageNum = chromedriver.findElement(By.cssSelector(".a-pagination li:nth-last-child(2)")).getText();
            int pageNum = Integer.parseInt(lastPageNum);
            for(int j = 2; j <= pageNum; j++){
                String eachUrl = ROOTURL+currentBook+"/ref=olp_page_"+j+"?ie=UTF8&startIndex="+10*(j-1);
                chromedriver.get(eachUrl);
                book.addBookItemToList(bookList, book, chromedriver);
            }

            Collections.sort(bookList, book.new BookComparator());
            for (Book.BookProduct bookOne : bookList) {
                System.out.println(bookOne.toString());
            }
            chromedriver.quit();
            break;
        }
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }
}

//       while(true){
//        List<WebElement> offerRows = chromedriver.findElements(By.className("olpOffer"));
//
//        for(int i = 0; i < offerRows.size(); i++){
//            String priceStr =  offerRows.get(i).findElement(By.className("olpOfferPrice")).getText();
//            String shipFeeStr = "0.0";
//            try {
//                shipFeeStr = offerRows.get(i).findElement(By.className("olpShippingPrice")).getText();
//            }catch (NoSuchElementException  e){
//                shipFeeStr = "0.0";
//            }
//            String conditionStr =  offerRows.get(i).findElement(By.className("olpCondition")).getText();
//            String ratingStr =  offerRows.get(i).findElement(By.cssSelector(".olpSellerColumn .a-spacing-small a b")).getText();
//
//            Double price = Double.parseDouble(priceStr.substring(1));
//            Double shipFee = Double.parseDouble(shipFeeStr.substring(1));
//            String condition =  conditionStr;
//            int rating = Integer.parseInt(ratingStr.split("%")[0]);
//            Book.BookProduct bookItem = book.new BookProduct(price,shipFee,condition,rating);
//            bookList.add(bookItem);
//        }
//
//
//        break;
//    }


}
