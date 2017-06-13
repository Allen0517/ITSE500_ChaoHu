/**
 * Created by IT on 2017/6/13.
 */
public class Vampire {

    public static void main(String[] args) {
        for (int i = 1000; i<10000; i++) {
            getVampireNumber(i);
        }
    }

//    result:
//    1260 =  12 * 60
//    1395 =  13 * 95
//    1435 =  14 * 35
//    1530 =  15 * 30
//    1827 =  18 * 27
//    2187 =  21 * 87
//    6880 =  68 * 80


    private static void getVampireNumber(int n) {
        int a = n / 1000;
        int b = (n / 100) % 10;
        int c = (n / 10) % 10;
        int d = n % 10;

        if (n == (a*10 + b) * (c*10 + d)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (a*10 + b) * (d*10 + c)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (a*10 + c) * (b*10 + d)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (a*10 + c) * (d*10 + b)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (a*10 + d) * (c*10 + b)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (a*10 + d) * (b*10 + c)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }

        if (n == (b*10 + a) * (c*10 + d)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (b*10 + a) * (d*10 + c)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (b*10 + c) * (d*10 + a)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (b*10 + d) * (c*10 + a)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }

        if (n == (c*10 + a) * (d*10 + b)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }
        if (n == (c*10 + b) * (d*10 + a)) { System.out.println(n + " =  " + a + "" + b + " * " + c + "" + d); return; }

    }

}
