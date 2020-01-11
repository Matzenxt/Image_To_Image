import java.io.File;

/**
 * Created by Matthias Lodner on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        File fileforeground = new File("/C:/Users/matth/Desktop/Wasserzeichen_Makro_2.png");
        File folder = new File("./ImageInput");


        ImageOverlayMaker imageOverlayMaker = new ImageOverlayMaker();
        imageOverlayMaker.addOverlayToMulitpleImages(fileforeground, folder, "./ImageOutput/", 0,0);
    }
}
