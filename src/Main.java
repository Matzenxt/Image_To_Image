import java.io.File;

/**
 * Created by Matthias Lodner on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        File fileforeground = new File("C:\\Users\\matth\\Documents\\Projekte\\Image_To_Image\\src\\Wasserzeichen\\Wasserzeichen_Makro_1.png");
        System.out.println("TEST");
        File folder = new File("C:\\Users\\matth\\Documents\\Projekte\\Image_To_Image\\src\\ImageInput");


        ImageOverlayMaker imageOverlayMaker = new ImageOverlayMaker();
        imageOverlayMaker.addOverlayToMulitpleImages(fileforeground, folder, "C:\\Users\\matth\\Documents\\Projekte\\Image_To_Image\\src\\ImageOutput\\", 0,0);
    }
}
