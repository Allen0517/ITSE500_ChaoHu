import java.util.HashSet;
import java.util.*;

/**
 * Created by IT on 2017/5/2.
 */
public class SetDemo {

    public static void main(String[] args){
        int count[] = {32,44,55,35,22,22};
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<6; i++){
            set.add(count[i]);
        }
        System.out.println(set.size());
        System.out.println(set);

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("defg");
        System.out.println(list);

        List list2 =new LinkedList();
        list2.add(11);
        list2.add(12);
        list2.add(11);
        list2.add(13);
        System.out.println(list2);





    }


//    public static void afga(String args[]) {
//        int count[] = {34, 22,10,60,30,22};
//        Set<Integer> set = new HashSet<Integer>();
//        try {
//            for(int i = 0; i < 5; i++) {
//                set.add(count[i]);
//            }
//            System.out.println(set);
//
//            TreeSet sortedSet = new TreeSet<Integer>(set);
//            System.out.println("The sorted list is:");
//            System.out.println(sortedSet);
//
//            System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
//            System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
//        }
//        catch(Exception e) {}
//    }
}
