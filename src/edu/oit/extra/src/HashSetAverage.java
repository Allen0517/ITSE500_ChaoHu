/**
 * Created by IT on 2017/6/13.
 */
import javax.swing.*;
import java.util.*;
public class HashSetAverage {
    public static void main(String[]args) {
        HashSet<Integer> h = new HashSet<Integer>();
        h.add(3);
        h.add(2);
        h.add(6);
        h.add(7);

        Iterator<Integer> i = h.iterator();
        int sum = 0;
        while (i.hasNext()){
            sum += i.next();
        }
        int average = sum/h.size();
        System.out.println(average);
//        result:4
    }
}
