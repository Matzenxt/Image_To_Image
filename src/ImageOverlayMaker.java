import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matthias Lodner on 18.07.2017.
 */
public class ImageOverlayMaker {

    public void addOverlayToSingleImage(File fileImageOverlay, File fileImageBackground, File pathExport, String newImageName, int posX, int posY) throws IOException {
        Image imageforeground = ImageIO.read(fileImageOverlay);

        BufferedImage bufferedImage = ImageIO.read(fileImageBackground);
        Graphics graphics = bufferedImage.getGraphics();


        graphics.drawImage(imageforeground,posX,posY,null);
        graphics.dispose();

        //ImageIO.write(bufferedImage, "png", new File("./ImageOutput/" + fileImageBackground.getName()));

        ImageIO.write(bufferedImage, "png", new File(pathExport.getPath() + newImageName));
    }


}
