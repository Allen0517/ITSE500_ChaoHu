import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IT on 2017/6/13.
 */

public class Book {

    public String name;
    public Book(String name){
        this.name = name;
    }



    public class BookProduct{
        public Double price;
        public Double shipFee;
        public String condition;
        public int positive;
        public int rating;

        public BookProduct(){
        }
        public BookProduct(Double price, Double shipFee, String condition, int positive, int rating){
            this.price =price;
            this.shipFee = shipFee;
            this.condition = condition;
            this.positive = positive;
            this.rating = rating;
        }
        public java.lang.Double getPrice() {
            return price;
        }
        public void setPrice(Double price){
            this.price = price;
        }

        public java.lang.Double getShipFee() {
            return shipFee;
        }
        public void setShipFee(Double shipFee){
            this.shipFee = shipFee;
        }

        public String getCondition(){
            return condition;
        }
        public void setCondition(String condition){
            this.condition = condition;
        }

        public int getPositive(){
            return positive;
        }
        public void setPositive(int positive){
            this.positive = positive;
        }

        public int getRating(){
            return rating;
        }
        public void setRating(int rating){
            this.rating = rating;
        }

        public String toString(){
            return "[price: " + price + ", shipFee: " + shipFee
                    + ", condition: "+ condition+", positive: " + positive + ", rating: " + rating + "]";
        }
    }


    class BookComparator implements Comparator<BookProduct> {
        public int compare(Book.BookProduct book1, Book.BookProduct book2) {
            int sort;
            sort = Double.compare((book1.getPrice()+book1.getShipFee()),(book2.getPrice()+book2.getShipFee()));
            if(sort == 0){
                sort = book1.getCondition().compareTo(book2.getCondition());
            }
            if(sort == 0){
                sort = Integer.compare(book1.getPositive(),book2.getPositive());
            }
            if(sort == 0){
                sort = Integer.compare(book1.getRating(),book2.getRating());
            }
            return sort;
        }
    }

    public void addBookItemToList(List<BookProduct> bookList, Book book, WebDriver chromedriver, boolean filter,  String shipFeeFilter,String conditionFilter, int positiveFilter, int ratingFilter){
        List<WebElement> offerRows = chromedriver.findElements(By.className("olpOffer"));
        for(int i = 0; i < offerRows.size(); i++){
            String priceStr =  offerRows.get(i).findElement(By.className("olpOfferPrice")).getText();
            String shipFeeStr = "0.0";
            try {
                shipFeeStr = offerRows.get(i).findElement(By.className("olpShippingPrice")).getText();
            }catch (NoSuchElementException e){
                shipFeeStr = "0.0";
            }
            String conditionStr =  offerRows.get(i).findElement(By.className("olpCondition")).getText();
            String positiveStr = "0%";
            try{
                positiveStr =  offerRows.get(i).findElement(By.cssSelector(".olpSellerColumn .a-spacing-small a b")).getText();
            }catch (NoSuchElementException e){
                positiveStr = "0%";
            }
            String ratingStr = "(0)";
            try{
                ratingStr =  offerRows.get(i).findElement(By.cssSelector(".olpSellerColumn .a-spacing-small")).getText();
                if(ratingStr.contains("(Seller Profile)")){
                    ratingStr = "(0)";
                }
            }catch (NoSuchElementException e){
                ratingStr = "(0)";
            }
            Double price = Double.parseDouble(priceStr.substring(1).replaceAll(",",""));
            Double shipFee = Double.parseDouble(shipFeeStr.substring(1));
            String condition =  conditionStr;

            int positive = Integer.parseInt(positiveStr.split("%")[0]);

            Pattern patPrice = Pattern.compile("\\(([0-9,]+)(.*)\\)");
            Matcher matPrice = patPrice.matcher(ratingStr);
            String ratingString = "";
            while(matPrice.find()){
                ratingString = matPrice.group(1).toString();
            }

            int rating = Integer.parseInt(ratingString.replaceAll(",",""));

            Book.BookProduct bookItem = book.new BookProduct(price,shipFee,condition,positive, rating);
            Book.BookProduct tempBook = bookItem;
            tempBook = filterBookItem(filter,shipFeeFilter,conditionFilter, positiveFilter,ratingFilter, bookItem);
            if(tempBook == null) continue;
            bookList.add(tempBook);
        }
    }

    public Book.BookProduct filterBookItem(boolean filter,  String shipFee, String condition, int positive, int rating,Book.BookProduct bookItem){
        if(!filter) return bookItem;
        if(shipFee != "original"){
            if(shipFee == "prime"){
                bookItem.setShipFee(0.0);
            }else if(bookItem.price < 35.0){
                bookItem.setShipFee(4.98);
            }else{
                Double shippingFee = bookItem.getShipFee();
                try{
                    shippingFee = Double.parseDouble(shipFee);
                }catch(NumberFormatException e){
                    String errorException = e.toString();
                }finally {
                    if(!shippingFee.isNaN()) bookItem.setShipFee(shippingFee);
                }
            }
        }

        if(condition.toLowerCase().equals("used")){
            if(!bookItem.getCondition().contains("Used")) return null;
        }else if(condition.toLowerCase().equals("new")){
            if(!bookItem.getCondition().contains("New")) return null;
        }
        if(bookItem.getPositive()< positive) return null;
        if(bookItem.getRating()< rating) return null;
        return bookItem;
    }
}
