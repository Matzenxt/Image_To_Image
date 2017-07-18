import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matthias Lodner on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        File fileforeground = new File("/C:/Users/Matthias/Desktop/Kreis.png");

        File folder = new File("./ImageInput");
        File[] listOfFilesBackground = folder.listFiles();

        Image imageforeground = ImageIO.read(fileforeground);

        BufferedImage bufferedImage = null;
        Graphics graphics = null;

        for(File file : listOfFilesBackground){
            if(file.isFile()){
                bufferedImage = ImageIO.read(file);

                graphics = bufferedImage.getGraphics();

                graphics.drawImage(imageforeground,500,0,null);
                graphics.dispose();

                ImageIO.write(bufferedImage, "png", new File("./ImageOutput/" + file.getName()));
            }
        }



    }
}
