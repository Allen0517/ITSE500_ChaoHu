/**
 * Created by IT on 2017/4/26.
 */
public class Zoo {
    public String name;
    private String place;
    private int area;

    public Zoo(String name, String place, int area){
        this.name = name;
        this.place = place;
        this.area = area;
        System.out.println("Welcome to " + name);
    }

    public int getArea(){
        return area;
    }
    public void setArea(int area){
        this.area = area;
    }
    public Zoo(){
    }

    public static void main(String[] args) {
        Lion xin = new Lion();

        xin.intro();//I am nulland I belong to null
    }
}

class Animal extends Zoo{
    public String type;
    private String food;
    public String myname;

    public Animal(String myname, String type){
        this.myname = myname;
        this.type = type;
    }
    public Animal(){

    }

    public void intro(){
        System.out.println("I am " + name + "and I belong to " + type);
    }
    public String action(String actionName, String thing){
        String result;
        result = "I am " + actionName +" " + thing;
        return result;
    }
}

class Lion extends Animal{

    public void intro(){
        System.out.println("I am " + super.myname + "and I belong to " + super.type);
    }

    public void eat(String food){
        System.out.println("I am eating "+food );
    }
        }
