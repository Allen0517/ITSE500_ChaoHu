import org.junit.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(daycount(2017, 6));
    }

    public static int daycount(int year, int month){
        int day = 0;
        if(month == 2){
            if(year%4 == 0 && year%100 != 0 || year%400 == 0){
                day = 29;
            }else{
                day = 28;
            }
        }else if(month == 4 || month==6 || month == 9 || month == 11){
            day = 30;
        }else{
            day = 31;
        }
        return day;
    }
}