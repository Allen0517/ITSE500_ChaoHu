/**
 * Created by IT on 2017/6/11.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) throws MineInputMismatchException, MineArithmeticException {
        int num1 = 100;
        int num2, result;
        Scanner input;

        while (true) {
            try {
                input = new Scanner(System.in);
                System.out.println("Enter division by:");
                num2 = input.nextInt();
                result = num1 / num2;
                System.out.printf("The result is: %d\n", result);
                input.close();
                break;
            } catch (ArithmeticException e) {
                throw new MineArithmeticException();
            } catch (InputMismatchException e) {
                throw new MineInputMismatchException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
