/**
 * Created by IT on 2017/5/4.
 */

import java.util.*;
public class CountSet {

    public static int numUniqueValues(List<Integer> listvar) {
        Set setList = new HashSet();

        for (int i = 0; i < listvar.size(); i++) {
            setList.add(listvar.get(i));
        }
        return setList.size();
    }

    public static void main(String args[]) {
        List listvar = new ArrayList(){{
            add(3);
            add(7);
            add(3);
            add(-1);
            add(2);
            add(3);
            add(7);
            add(2);
            add(15);
            add(15);
        }};
        int num = 0;
        num = numUniqueValues(listvar);
        System.out.println(num);
    }
}