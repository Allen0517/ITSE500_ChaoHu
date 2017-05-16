import java.lang.reflect.Array;
import java.util.*;
public class SwitchPairs {

    public static boolean testNull(ArrayList listvar){
        if(listvar != null){
            for(int i=0; i<listvar.size();i++){
                if(listvar.get(i) == null){
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList switchPairs(ArrayList<String> inputList){
        ArrayList result = new ArrayList();
        ArrayList output = new ArrayList();
        if(!testNull(inputList)){
            int length = inputList.size();
            boolean even = length%2 == 0 ? false :true;
            if(!even){
                for(int i = 0; i<=length-2; i++){
                    if(i%2 == 0){
                        result.add(inputList.get(i+1).toString());
                        result.add(inputList.get(i).toString());
                    }
                }
                output = result;
            }else{
                for(int i = 0; i<=length-3; i++){
                    if(i%2 == 0){
                        result.add(inputList.get(i+1).toString());
                        result.add(inputList.get(i).toString());
                    }
                }
                result.add(inputList.get(length-1));
                output = result;
            }

            return output;
        }else{
            System.out.println("Input is null or it has null value, please input a no-null value");

            return output;
        }

    }

    public static void main(String[] args) {
        String[] temp = {"a", "bb", "c", "ddd", "ee", "f", "fh"};
        ArrayList list = new ArrayList(Arrays.asList(temp));
        System.out.println(list.toString());
        ArrayList result = SwitchPairs.switchPairs(list);
        System.out.println(result.toString());
    }
}
