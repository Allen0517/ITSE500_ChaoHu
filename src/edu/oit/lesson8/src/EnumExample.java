/**
 * Created by IT on 2017/5/11.
 */
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;
public class EnumExample {


    public static void main(String[] args){

        AmazonCountry.US.getName();
        AmazonCountry.US.getUrl();

        AmazonCountry[] euro = {AmazonCountry.DE,AmazonCountry.UK,AmazonCountry.FR};
        for(AmazonCountry eurocountry: euro){
            eurocountry.getName();
            eurocountry.getUrl();
        }
    }



}
