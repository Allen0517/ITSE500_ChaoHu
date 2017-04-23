/**
 * Created by IT on 2017/4/23.
 */
import java.util.Scanner;
import java.lang.StringBuffer;
public class ReverseString {
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
//        ReverseString reverseStr = new ReverseString();
        StringBuffer inputString = new StringBuffer("");

        System.out.println("Enter a String:");
        inputString.append(input.nextLine());
        System.out.println(reverseString(inputString));
//        System.out.println(ReverseString.reverseStr(input.nextLine()));
    }

    public static StringBuffer reverseString (StringBuffer inputString){
        return inputString.reverse();
    }

    public static String reverseStr(String input){
        int len = input.length();
        String output = "";
        for (int i = 0; i<len; i++) {
            output = output + input.charAt((len-1-i));
        }
        return output;
    }

}
