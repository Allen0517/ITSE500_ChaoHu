/**
 * Created by IT on 2017/5/4.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;


public class MapIterationDemo {

    public static void main(String args[]) {
        Map<String,Integer> map = new HashMap<>();
        map.put("jay", 89);
        map.put("joyce",79);
        map.put("allen", 99);
        for(Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" got " + entry.getValue());
        }

        for (Integer value:map.values()){
            System.out.println(value);
        }

        for (String name: map.keySet()){
            System.out.println(name);
        }

        Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) entries.next();
            String key = (String) entry.getKey();
            Integer value = (Integer) entry.getValue();
            System.out.println(key+": " + value);
        }

        Iterator<Integer> value = map.values().iterator();
        while(value.hasNext()){
            System.out.println(value.next());
        }

        Iterator<String> key = map.keySet().iterator();
        while(key.hasNext()){
            System.out.println(key.next());
        }
    }
}














































