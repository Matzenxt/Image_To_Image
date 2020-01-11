import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

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
        Timestamp timestampStart = new Timestamp(System.currentTimeMillis());
        System.out.println("Start job at: " + timestampStart);


        Image imageforeground = ImageIO.read(fileImageOverlay);

        BufferedImage bufferedImage;
        Graphics graphics;

        File[] listOfFilesBackground = folderPath.listFiles();

        System.out.println("Total images: " + listOfFilesBackground.length + "\n");
        long counter = 1;
        long millis;
        long length = listOfFilesBackground.length;
        Timestamp imageStart;
        Timestamp imageFinished;

        for(File file : listOfFilesBackground){
            imageStart = new Timestamp(System.currentTimeMillis());
            System.out.print(String.format("Image: %03d of %03d", counter, length));
            if(file.isFile()){
                bufferedImage = ImageIO.read(file);

                graphics = bufferedImage.getGraphics();

                graphics.drawImage(imageforeground, posX, posY,null);
                graphics.dispose();

                ImageIO.write(bufferedImage, "png", new File(ExportFolder + file.getName()));
            }

            imageFinished = new Timestamp(System.currentTimeMillis());
            millis = (imageFinished.getTime() - imageStart.getTime());
            String dif = String.format("%02d min, %02d sec",
                    TimeUnit.MILLISECONDS.toMinutes(millis),
                    TimeUnit.MILLISECONDS.toSeconds(millis) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
            );

            System.out.println("    -    " + dif);
            counter++;
        }

        Timestamp timestampFinished = new Timestamp(System.currentTimeMillis());
        millis = (timestampFinished.getTime() - timestampStart.getTime());
        String dif = String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
        System.out.println("\n\nStart job at: " + timestampFinished + "    ---    duration: " + dif);
    }
}
