/**
 * Created by IT on 2017/4/23.
 */
import sun.font.TrueTypeFont;

import java.util.Scanner;
public class ScannerDemo {
    private static Scanner input;

    public static void main(String[] args) {
        int number1, number2, sum;
        String push;
        boolean stop = false;
        while(true){
            input = new Scanner(System.in);
            System.out.println("Enter first multiple:");
            number1 = input.nextInt();

            System.out.println("Enter second multiple:");
            number2 = input.nextInt();

            sum = number1 * number2;
            System.out.println(number1 + " * " + number2 + " = " + sum);
            System.out.println("\n");
            System.out.println("Are you going to stop: N/Y");
            push = input.next();
            System.out.println(push);
            if(push.toString() == "Y"){
                break;
            }
        }

    }

}
