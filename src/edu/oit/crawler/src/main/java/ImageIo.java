/**
 * Created by IT on 2017/6/12.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageIo {

    public static void main( String[] args )
    {
        BufferedImage image = null;
        try {

            URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
            image = ImageIO.read(url);

            ImageIO.write(image, "jpg",new File("out.jpg"));
            ImageIO.write(image, "gif",new File("out.gif"));
            ImageIO.write(image, "png",new File("out.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
