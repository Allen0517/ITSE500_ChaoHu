
import java.util.stream.IntStream;
public class DayCounter {

    public static void main(String[] args) {
        int year = 2000;
        int month = 2;
        System.out.println(getDays(isLeap(year), month));
    }

    // check if it's leap year
    public static boolean isLeap(int year) {
        boolean leap = false;
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                leap = true;
            }
        } else {
            if (year % 4 == 0) {
                leap = true;
            }
        }
        return leap;
    }

    public static int getDays(boolean leap, int month) {
        // default {1,3,5,7,8,10,12}, 31 days
        int count = 31;
        int months[] = { 4, 6, 9, 11 };

        // check months: {4,6,9,11}
        if (IntStream.of(months).anyMatch(x -> x == month)) {
            count = 30;
            // check month: 2
        } else if (month == 2) {
            count = (leap) ? 29 : 28;
        }

        return count;
    }
}