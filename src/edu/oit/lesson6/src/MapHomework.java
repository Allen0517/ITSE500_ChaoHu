import java.util.HashMap;
import java.util.*;
import java.lang.*;
/**
 * Created by IT on 2017/5/8.
 */
public class MapHomework {

    public static int leastCommon(HashMap<String, Integer> map1) {
        int a = 1;
        HashMap<Integer, Integer> mapResult = new HashMap<Integer, Integer>();
        ArrayList<Integer> mapValue = new ArrayList<Integer>(map1.values());
        int mapValueSize = mapValue.size();
        for (int i = 0; i < mapValueSize; i++) {
            int value = mapValue.get(i);
            int count = 1;
            if (mapResult.containsKey(value)) {
                count = mapResult.get(value) + 1;
            }
            mapResult.put(value, count);
        }

        int countMin = Collections.min(mapResult.values());
        for (Integer key : mapResult.keySet()) {
            if (mapResult.get(key) == countMin) {
                a = key;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> m1 = new HashMap();
        m1.put("Zara", 2);
        m1.put("Mahnaz", 2);
        m1.put("Ayan", 3);
        m1.put("Daisy", 4);

       int result = MapHomework.leastCommon(m1);
       System.out.println(result);
    }

}
