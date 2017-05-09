/**
 * Created by IT on 2017/5/4.
 */
import java.util.*;
public class Makelist {

    public static List<Integer> alternate(ArrayList<Integer> list1,ArrayList<Integer> list2){
        int size1 = 0;
        int size2 = 0;
        int min = 0;
        int lengthLeft = 0;

        size1 = list1.size();
        size2 = list2.size();
        min = Math.min(size1,size2);
        lengthLeft = Math.abs(size1-size2);

        List<Integer> listReturn = new ArrayList<Integer>();

        for(int i =0; i < min;i++){
            if(i%2 == 0){
                listReturn.add(list1.get(i));
                listReturn.add(list1.get(i+1));
                listReturn.add(list2.get(i));
                listReturn.add(list2.get(i+1));
            }
        }
        if(size1>=size2){
            for(int i=0;i<lengthLeft; i++){
                listReturn.add(list1.get(size2+i));
            }
        }else{
            for(int i=0;i<lengthLeft; i++){
                listReturn.add(list2.get(size1+i));
            }
        }

        return listReturn;
    }

    public static void main(String args[]) {
        List<Integer> list3 = new ArrayList<Integer>();

        ArrayList<Integer> list1 = new ArrayList(Arrays.asList(1,1,1,1));
        ArrayList<Integer> list2= new ArrayList(Arrays.asList(2,2,2,2,2,2,2,2));
        list3 = Makelist.alternate(list1,list2);
        System.out.println(list3.toString());

    }

}
