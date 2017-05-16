import java.util.Random;

/**
 * Created by IT on 2017/5/15.
 */
public class Method {

    public static String addCommas(String numberString){
        String result = "";
        int length = numberString.length();
        int reminder = length%3;
        if(reminder == 0){
            for(int i = 0; i<length-2; i++){
                if(i%3 == 0){
                    result = (i==length-3) ? (result + numberString.substring(i,i+3)): (result + numberString.substring(i,i+3)+",") ;
                }
            }
        }else{
            result = result + numberString.substring(0,reminder)+",";
            for(int i = reminder; i<length-2; i++){
                if((i-reminder)%3 == 0){
                   result = (i==length-3) ? (result + numberString.substring(i,i+3)): (result + numberString.substring(i,i+3)+",") ;
                }
            }
        }
        return result;
    }

    public static boolean isVowel(String input){
        boolean result = false;
        if(input.length() == 1){
           result =  input.matches("[aeiou]");
        }
        return result;
    }

    public static boolean isMultiple(double a, double b){
        boolean result = false;
        if(a>0 && b>0){
           result =  (a%b == 0) ? true : false;
        }
        return result;
    }

    public static String coinFlip(int k, String side){
        String result ="Error!";
        if(k<0 || !side.matches("[HT]")){
            return result;
        }else{
            String temp = side;
            String output = "";
            Random random = new Random();
            int count = 1;
            while(count < k){
                double next = random.nextGaussian();
                String sideEach = (next > 0.50) ? "H" : "T";

                if(sideEach == temp && sideEach == side){
                    count = count+1;
                    if(count == k){
                        output =  output + sideEach+" ";
                        break;
                    }
                }else{
                    count = 1;
                }
                temp = sideEach;
                output =  output + sideEach+" ";
            }
            result = output + "\n" + "you got " + side + " "+ k + " times in a row!";
        }
        return result;
    }

    public static void main(String[] args) {
        String num = "1234567893344";
        String result = Method.addCommas(num);
        System.out.println(result);

        String a = "b";
        System.out.println(Method.isVowel(a));

        System.out.println(Method.isMultiple(12,2));

        System.out.println(Method.coinFlip(4,"T"));
    }
}
