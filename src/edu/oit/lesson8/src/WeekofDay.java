/**
 * Created by IT on 2017/5/11.
 */
public enum WeekofDay {
    Mon(1), Tue(2), Wed(3), Thu(4),Fri(5),Sat(6),Sun(7);

    private int index;

    WeekofDay(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

     public void dosthing () {
        switch (this){
            case Mon:
                System.out.println("Do Monday work");
                break;
            case Tue:
                System.out.println("Do Tuesday work");
                break;
            case Wed:
                System.out.println("Do Wednesday work");
                break;
            case Thu:
                System.out.println("Do Thursday work");
                break;
            case Fri:
                System.out.println("Do Friday work");
                break;
            case Sat:
                System.out.println("Do Saturday work");
                break;
            case Sun:
                System.out.println("Do Sunday work");
                break;
            default:
                System.out.println("I don't know which is day");
                break;
        }
     }


}
