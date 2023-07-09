package helpers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomImage {
    public static JLabel loadImage(String fileName, int x, int y ,int width, int height) {

        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(x,y,width,height);
        BufferedImage logo = null;
        try{

            String fullPath = "src/assets/" + fileName;
            logo = ImageIO.read(new File(fullPath));
        }
        catch (Exception e){
            System.out.println("Image cannot be loaded probably name or path is wrong" + e.getMessage());
        }

        ImageIcon imageIcon = new ImageIcon(fitImage(logo, logoLabel.getWidth(), logoLabel.getHeight()));
        logoLabel.setIcon(imageIcon);

        return logoLabel;
    }


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
