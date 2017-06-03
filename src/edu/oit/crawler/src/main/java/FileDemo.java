/**
 * Created by IT on 2017/6/1.
 */
import java.io.*;

public class FileDemo {
//    public static void main(String[] args){
//        File file = new File("Documents");
//        String[] fileNames = file.list();
//        for (String filename : fileNames){
//            System.out.println(filename);
//        }
//
//        File[] files = file.listFiles();
//        for (File fileeach : files){
//            System.out.println(fileeach.getName());
//        }
//        File dir = new File(file, "taobao/keyowrds.txt");
//        dir.delete();
//
//        FileReader fr = null;
//        BufferedReader br = null;
//        try {
//            File file1 = new File("document");
//            File linkFile = new File(file1, "links.txt");
//            fr = new FileReader(linkFile);
//            br = new BufferedReader(fr);
//            String currentLine;
//            while ((currentLine = br.readLine()) != null) {
//                System.out.println(currentLine);
//            }
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

//    }

        public static void main(String[] args) {
            File file;
            File linkFile = null;
            try {
                file = new File("Documents");
                linkFile = new File(file, "links.txt");
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new FileReader(linkFile))) {
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    System.out.println(currentLine);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


//            try(BufferedWriter bw = new BufferedWriter(new FileWriter(linkFile, true))) {
//                bw.write("\ntaobao.com");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


}
}













