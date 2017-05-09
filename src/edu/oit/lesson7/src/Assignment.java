/**
 * Created by IT on 2017/5/9.
 */
import java.util.*;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assignment {

    public static Set<Integer> removeRange (Set<Integer> set1, int minvalue, int maxvalue){
       Iterator<Integer> allValue = set1.iterator();
       while(allValue.hasNext()){
           Integer inttemp  = allValue.next();
           if(inttemp>= minvalue && inttemp <= maxvalue ){
               allValue.remove();
           }
       }
       return set1;
    }



    public static Map<String, String> teacher(Map<String, Integer> roster, Map<Integer, String> gradeMap) {
        Map<String, String> studentGrade = new HashMap();
        Map<Integer, String> mapGrade = new TreeMap<Integer, String>(gradeMap);

        Iterator<Entry<String, Integer>> rosterEntry = roster.entrySet().iterator();
        while(rosterEntry.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) rosterEntry.next();
            String studnetName = entry.getKey();
            Integer studentPercent = entry.getValue();

            Iterator<Entry<Integer, String>> grades = mapGrade.entrySet().iterator();
            while(grades.hasNext()){
                Map.Entry<Integer, String> grade = (Map.Entry<Integer, String>) grades.next();
                Integer gradePercent = grade.getKey();
                if(gradePercent <= studentPercent){
                    String studentGradetemp = grade.getValue();
                    studentGrade.put(studnetName,studentGradetemp);
                }
            }

        }
        return studentGrade;
    }


    public static void main(String[] args) {
        Map<String, Integer> roster = new HashMap<>();
        roster.put("Mort", 77);
        roster.put("Dan", 81);
        roster.put("Alyssa", 98);
        roster.put("Kim", 52);
        roster.put("Lisa", 87);
        roster.put("Bob", 43);
        roster.put("Jeff", 70);
        roster.put("Sylvia", 92);
        roster.put("Vikram", 90);
        // {52=D, 70=C-, 73=C, 76=C+, 80=B-, 84=B, 87=B+, 89=A-, 91=A, 98=A+}
        Map<Integer, String> gradeMap = new HashMap<>();
        gradeMap.put(0, "F");
        gradeMap.put(52, "D");
        gradeMap.put(70, "C-");
        gradeMap.put(73, "C");
        gradeMap.put(76, "C+");
        gradeMap.put(80, "B-");
        gradeMap.put(84, "B");
        gradeMap.put(87, "B+");
        gradeMap.put(89, "A-");
        gradeMap.put(91, "A");
        gradeMap.put(98, "A+");
        System.out.println(Assignment.teacher(roster, gradeMap).toString());
    }
}


