import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;

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
        public int rating;

        public BookProduct(){
        }
        public BookProduct(Double price, Double shipFee, String condition, int rating){
            this.price =price;
            this.shipFee = shipFee;
            this.condition = condition;
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

        public int getRating(){
            return rating;
        }
        public void setRating(int rating){
            this.rating = rating;
        }

        public String toString(){
            return "[price: " + price + ", shipFee: " + shipFee
                    + ", condition: "+ condition+ ", rating: " + rating + "]";
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
                sort = Integer.compare(book1.getRating(),book2.getRating());
            }
            return sort;
        }
    }

    public void addBookItemToList(List<BookProduct> bookList, Book book, WebDriver chromedriver){
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
            String ratingStr = "0%";
            try{
                ratingStr =  offerRows.get(i).findElement(By.cssSelector(".olpSellerColumn .a-spacing-small a b")).getText();
            }catch (NoSuchElementException e){
                ratingStr = "0%";
            }
            Double price = Double.parseDouble(priceStr.substring(1));
            Double shipFee = Double.parseDouble(shipFeeStr.substring(1));
            String condition =  conditionStr;
            int rating = Integer.parseInt(ratingStr.split("%")[0]);
            Book.BookProduct bookItem = book.new BookProduct(price,shipFee,condition,rating);
            bookList.add(bookItem);
        }
    }

}
