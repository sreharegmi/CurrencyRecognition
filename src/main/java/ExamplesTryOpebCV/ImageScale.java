package ExamplesTryOpebCV;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Created by Shreha on 4/30/2017.
 */

public class ImageScale extends JFrame{


    Image image;

    Insets insets;

    public ImageScale() {
        super();
        ImageIcon icon = new ImageIcon("/Users/apple/Documents/7th Semester/CurrencyRecognition/src/main/java/1000Currency.jpg");
        image = icon.getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (insets == null) {
            insets = getInsets();
        }
        g.drawImage(image, insets.left, insets.top, this);
    }

    public void go() throws IOException {
        // Sleep first to see original
        Image original = image;
        image = original.getScaledInstance(400, -1, Image.SCALE_SMOOTH);

        File file = new File("D:\\DEERWALK\\Seventh Semester\\Final Year Project - Currency\\CurrencyRecognition\\src\\main\\java\\ImageOperations\\Currency100.jpg");
//        ImageIO.write((BufferedImage) image,"jpg",file);
            toBufferedImage(image, file);
    }
    public static BufferedImage toBufferedImage(Image img, File file)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
//        ImageIO.write( img,"jpg",file);
        return bimage;
    }

    public static void main(String args[]) throws IOException {
        ImageScale f = new ImageScale();
        f.setSize(400, 400);
        f.show();
        f.go();
    }
}


