import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Matthias Lodner on 18.07.2017.
 */
public class ImageOverlayMaker {

    /**
     * Method to add an overlay image to an background image
     */
    public void addOverlayToSingleImage(File fileImageOverlay, File fileImageBackground, File ExportFile, int posX, int posY) throws IOException {
        Image imageforeground = ImageIO.read(fileImageOverlay);

        BufferedImage bufferedImage = ImageIO.read(fileImageBackground);
        Graphics graphics = bufferedImage.getGraphics();

        graphics.drawImage(imageforeground,posX,posY,null);
        graphics.dispose();

        ImageIO.write(bufferedImage, "png", ExportFile);
    }

    /**
     * Method to add an overlay image to all images in a folder
     */
    public void addOverlayToMulitpleImages(File fileImageOverlay, File folderPath, String ExportFolder, int posX, int posY) throws IOException {
        Image imageforeground = ImageIO.read(fileImageOverlay);

        BufferedImage bufferedImage = null;
        Graphics graphics = null;

        File[] listOfFilesBackground = folderPath.listFiles();

        for(File file : listOfFilesBackground){
            if(file.isFile()){
                bufferedImage = ImageIO.read(file);

                graphics = bufferedImage.getGraphics();

                graphics.drawImage(imageforeground, posX, posY,null);
                graphics.dispose();

                ImageIO.write(bufferedImage, "png", new File(ExportFolder + file.getName()));
            }
        }
    }


}
