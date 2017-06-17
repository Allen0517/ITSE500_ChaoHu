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
        File input = new File(file1, "products.txt");

        File file2 = new File("output");
        File output = new File(file2, "results.txt");

        fr = new FileReader(input);
        br = new BufferedReader(fr);
        String currentBook;
        while ((currentBook = br.readLine()) != null) {
            System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");

            WebDriver chromedriver = new ChromeDriver();
            String url = ROOTURL + currentBook;
            chromedriver.get(url);

            Book book = new Book(currentBook);
            List<Book.BookProduct> bookList = new ArrayList<Book.BookProduct>();
//            setup rules;
             String shipFeeFilter = "original";
             String conditionFilter = "All";
             int positiveFilter = 95;
             int ratingFilter = 100;
//            InputRules inputrules = new InputRules();
            boolean filter = true;
//            String shipFeeFilter = inputrules.shipFeeFilter;
//            String conditionFilter = inputrules.conditionFilter;
//            int positiveFilter = inputrules.positiveFilter;
//            int ratingFilter = inputrules.ratingFilter;

            book.addBookItemToList(bookList, book, chromedriver,filter,shipFeeFilter,conditionFilter,positiveFilter,ratingFilter);

            try{
                String lastPageNum = chromedriver.findElement(By.cssSelector(".a-pagination li:nth-last-child(2)")).getText();
                int pageNum = Integer.parseInt(lastPageNum);
                for(int j = 2; j <= pageNum; j++){
                    String eachUrl = ROOTURL+currentBook+"/ref=olp_page_"+j+"?ie=UTF8&startIndex="+10*(j-1);
                    chromedriver.get(eachUrl);
                    book.addBookItemToList(bookList, book, chromedriver,filter,shipFeeFilter,conditionFilter,positiveFilter,ratingFilter);
                }
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }

            Collections.sort(bookList, book.new BookComparator());

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(output, true))) {
                bw.write("Book: "+currentBook+" sorted results:"+"\n");
                for (Book.BookProduct bookOne : bookList) {
                    bw.write(bookOne.toString()+"\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            chromedriver.quit();
        }
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();
    }
}
}
