/**
 * Created by IT on 2017/5/15.
 */

import java.util.Scanner;
public class FibonacciSequence {

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("Max value ? " + n);
        for (int i = 1; i <= n; i++)
            if( fibonacci(i) >= (long)n){
                break;
            }else{
                System.out.println(i + ": " + fibonacci(i));
            }
    }
}
