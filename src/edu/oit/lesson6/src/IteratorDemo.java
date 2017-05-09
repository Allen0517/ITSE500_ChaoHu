import java.util.*;

/**
 * Created by IT on 2017/5/4.
 */
public class IteratorDemo {
    public static void main(String args[]) {
        Set<String> set = new HashSet<>();
        set.add("San Francisco");
        set.add("dog");
        set.add("San Jose");
        set.add("San Diego");

        for(String item: set){
            System.out.println(item);
        }

        Iterator<String> iterator1 = set.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        Integer[] numbers = {2,3,5,1,5};
        List<Integer> list = Arrays.asList(numbers);
        int max = 0;
        for (int i=0; i<list.size();i++){
            int element = list.get(i);
            if (element > max){
                max = element;
            }
        }

        Integer[] num2 = {2,3,4,5,20,13,-9};
        List<Integer> list2 = Arrays.asList(num2);
        int maxvalue = 0;

        for (Integer num: list2){
            if(num > maxvalue){
                maxvalue = num;
            }
        }

        Iterator<Integer> numIterator = list2.iterator();
        while (numIterator.hasNext() ){
            Integer numtemp = numIterator.next();
            if(numtemp>maxvalue){
                maxvalue = numtemp;
            }
        }
        System.out.println("Iterator get max : " + maxvalue);

    }

}























