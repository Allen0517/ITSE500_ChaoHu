import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Demo demo = new Demo();
        List<Student> list = new ArrayList<Student>(); // your Car list

        Student st = demo.new Student();
        st.setName("sekhar");
        st.setCity("bbsr");
        st.setRoll(23);
        list.add(st);

        st = demo.new Student();
        st.setName("himanshu");
        st.setCity("agra");
        st.setRoll(23);
        list.add(st);
        st = demo.new Student();
        st.setName("nitin");
        st.setCity("delhi");
        st.setRoll(23);
        list.add(st);
        st = demo.new Student();
        st.setName("nitin");
        st.setCity("delhi");
        st.setRoll(22);
        list.add(st);
        st = demo.new Student();
        st.setName("nitin");
        st.setCity("bbsr");
        st.setRoll(23);
        list.add(st);
        st = demo.new Student();
        st.setName("arun");
        st.setCity("patna");
        st.setRoll(23);
        list.add(st);
        st = demo.new Student();
        st.setName("arun");
        st.setCity("kendrapara");
        st.setRoll(23);
        list.add(st);
        System.out.println("before sort");
        System.out.println("Name:" + "-------------------" + "City...........roll");
        for (Student st1 : list) {
            System.out.println(st1.getName() + " --------------" + st1.getCity() + "------------" + st1.getRoll());
        }

        Collections.sort(list, demo.new CarHorsePowerComparator());
        System.out.println("after sort");
        System.out.println("Name:" + "-------------------" + "City...............roll");
        for (Student st1 : list) {
            System.out.println(st1.getName() + " --------------" + st1.getCity() + "------------" + st1.getRoll());
        }
    }

    public class Student {

        String name;
        String city;
        int roll;

        public int getRoll() {
            return roll;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

//    class CarHorsePowerComparator implements Comparator<Student> {
//        public int compare(Student stu, Student stu1) {
//            int sort = (stu.getName() + stu.getCity() + stu.getRoll()).compareTo((stu1.getName() + stu1.getCity() + stu1.getRoll()));
//            return sort;
//        }
//    }

    class CarHorsePowerComparator implements Comparator<Student> {
        public int compare(Student stu, Student stu1) {
            int sort;
            // Sort on Name first
            sort = stu.getName().compareTo(stu1.getName());
            if(sort == 0){
                // If name is equal, sort on city
                sort = stu.getCity().compareTo(stu1.getCity());
            }
            if(sort == 0){
                // If name and city is equal, sort on Roll
                sort = Integer.compare(stu.getRoll(),stu1.getRoll());
            }
            return sort;
        }
    }
}