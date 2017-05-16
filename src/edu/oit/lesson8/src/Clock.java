/**
 * Created by IT on 2017/5/14.
 */
public class Clock {
    private int hour;
    private int minute;
    private String amPm;
    private int day;

    public Clock(int hour, int minute, String amPm){
        this.hour = hour;
        this.minute = minute;
        this.amPm =amPm;
    }
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public String getAmPm(){
        return amPm;
    }
    public String toString(){
        return this.hour + ":" + this.minute + ":" + this.amPm;
    }

    public void advance(int minute){
        String ampm = this.amPm;
        int totalMinute = this.minute +minute;
        int nowMinute = totalMinute%60;
        int addHour = (totalMinute-nowMinute)/60+this.hour;
        int nowHour = addHour%12;
        int halfDay = (addHour-nowHour)/12;
        if(halfDay%2 == 0){
            this.amPm = ampm;
        }else{
            this.amPm = (ampm.equals("AM")? "PM" : "AM");
        }
        this.hour = nowHour;
        this.minute = nowMinute;
    }

    public static void main(String[] args) {
        Clock clockNow = new Clock(6,27,"PM");
        System.out.println(clockNow.toString());
        clockNow.advance(1);
        System.out.println(clockNow.toString());
        clockNow.advance(30);
        System.out.println(clockNow.toString());
        clockNow.advance(5);
        System.out.println(clockNow.toString());
        clockNow.advance(60);
        System.out.println(clockNow.toString());
        clockNow.advance(128);
        System.out.println(clockNow.toString());
        clockNow.advance(180);
        System.out.println(clockNow.toString());
        clockNow.advance(1440);
        System.out.println(clockNow.toString());
    }

}
