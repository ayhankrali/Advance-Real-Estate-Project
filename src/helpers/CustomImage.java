package helpers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomImage {
    public static JLabel loadImage(String fileName, int x, int y ,int width, int height) {
        //Малко промених кода, защото снимката излизаше ама много голяма и трябваше да се направи
        //така, че колкото и да е голям label-a самата снимка ще се resize-не по него
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(x,y,width,height);
        BufferedImage logo = null;
        try{
            //Тука не се слага пътя до C:/ бла бла ами папката src/ и името на файла, защото
            //Тази снимка е вече в проекта и където и да го пращаш винаги ще се показва снимката
            String fullPath = "src/assets/" + fileName;
            logo = ImageIO.read(new File(fullPath));
        }
        catch (Exception e){
            System.out.println("Image cannot be loaded probably name or path is wrong" + e.getMessage());
        }
        //Тука става това снимката да си сменя размера спрямо label-a
        ImageIcon imageIcon = new ImageIcon(fitImage(logo, logoLabel.getWidth(), logoLabel.getHeight()));
        logoLabel.setIcon(imageIcon);

        return logoLabel;
    }

    //Този метод можеш и на други проекти да го закачаш реално подава му се снимка и width и height
    //И той я resize-ва иначе излиза супер голяма и орязана в GUI-то
    private static Image fitImage(Image img , int w , int h)
    {
        BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0,w,h,null);
        g2.dispose();
        return resizedimage;
    }
}
