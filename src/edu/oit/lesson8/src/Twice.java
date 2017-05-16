import java.util.*;
public class Twice {

    public static ArrayList twice(ArrayList input){
        ArrayList output = new ArrayList();
        for (int i = 0; i<2; i++){
            output.addAll(input);
        }
        return output;
    }
    public static void main(String[] args) {
        ArrayList input = new ArrayList();
        input.add(2);
        input.add(2);
        input.add("here");

        ArrayList output = Twice.twice(input);
        System.out.println(output.toString());
    }
}
